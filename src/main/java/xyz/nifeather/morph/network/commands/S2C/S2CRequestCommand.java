package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.Arrays;

public class S2CRequestCommand extends AbstractS2CCommand<String>
{
    @Environment(EnvironmentType.CLIENT)
    public S2CRequestCommand(String rawArgs)
    {
        super(rawArgs.split(" "));
    }

    public S2CRequestCommand(Type requestType, String source)
    {
        super(new String[]{requestType.commandName, source});
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
        var typeStr = getArgumentAt(0, "?");

        System.out.println("typeStr: " + typeStr);

        this.type = Arrays.stream(Type.values()).filter(t -> t.commandName.equalsIgnoreCase(typeStr))
                    .findFirst().orElse(Type.Unknown);

        this.sourcePlayer = getArgumentAt(1, "Unknown source");

        handler.onExchangeRequestReceive(this);
    }

    public enum Type
    {
        NewRequest(S2CCommandNames.RequestNew),
        RequestSend(S2CCommandNames.RequestSend),
        RequestExpired(S2CCommandNames.RequestExpire),
        RequestExpiredOwner(S2CCommandNames.RequestExpireOwner),

        RequestAccepted(S2CCommandNames.RequestAccept),
        RequestDenied(S2CCommandNames.RequestDenied),
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
