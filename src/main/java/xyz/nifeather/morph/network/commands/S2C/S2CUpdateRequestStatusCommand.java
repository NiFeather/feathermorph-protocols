package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Arrays;
import java.util.Map;

public class S2CUpdateRequestStatusCommand extends AbstractS2CCommand<String>
{
    public static S2CUpdateRequestStatusCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var typeStr = Asserts.getStringOrThrow(arguments, "type");

        var type = Arrays.stream(Type.values()).filter(t -> t.commandName.equalsIgnoreCase(typeStr))
                .findFirst().orElse(Type.Unknown);

        var source = Asserts.getStringOrThrow(arguments, "source");

        return new S2CUpdateRequestStatusCommand(type, source);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("type", requestType.commandName,
                "source", source);
    }

    public final Type requestType;
    public final String source;

    public S2CUpdateRequestStatusCommand(Type requestType, String source)
    {
        this.requestType = requestType;
        this.source = source;
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.UpdateRequestStatus;
    }

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
