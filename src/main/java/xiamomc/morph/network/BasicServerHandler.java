package xiamomc.morph.network;

import xiamomc.morph.network.commands.C2S.AbstractC2SCommand;

public interface BasicServerHandler<TPlatformPlayer>
{
    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean sendCommand(AbstractC2SCommand<TPlatformPlayer, ?> c2SCommand);

    public abstract int getServerApiVersion();

    public abstract int getImplmentingApiVersion();
}
