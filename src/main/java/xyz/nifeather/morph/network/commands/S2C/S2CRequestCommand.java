package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class S2CRequestCommand extends AbstractS2CCommand<String>
{
    public static S2CRequestCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var typeStr = Asserts.getStringOrThrow(arguments, "type");

        var type = Arrays.stream(Type.values()).filter(t -> t.commandName.equalsIgnoreCase(typeStr))
                .findFirst().orElse(Type.Unknown);

        var source = Asserts.getStringOrThrow(arguments, "source");

        return new S2CRequestCommand(type, source);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("type", requestType.commandName,
                "source", source);
    }

    private final Type requestType;
    private final String source;

    public S2CRequestCommand(Type requestType, String source)
    {
        this.requestType = requestType;
        this.source = source;
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.Request;
    }

    @Environment(EnvironmentType.CLIENT)
    public Type type;

    @Environment(EnvironmentType.CLIENT)
    public String sourcePlayer;

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onExchangeRequestReceive(this);
    }

    public enum Type
    {
        NewRequest("new"),
        RequestSend("send"),
        RequestExpired("expire"),
        RequestExpiredOwner("expire_owner"),

        RequestAccepted("request_accepted"),
        RequestDenied("request_denied"),
        Unknown("unknown_type");

        public final String commandName;

        public boolean isRequestOwner()
        {
            return this == RequestExpiredOwner || this == RequestSend || this == RequestAccepted || this == RequestDenied;
        }

        Type(String cmdName)
        {
            this.commandName = cmdName;
        }
    }
}
