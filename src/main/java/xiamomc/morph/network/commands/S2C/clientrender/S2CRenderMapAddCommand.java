package xiamomc.morph.network.commands.S2C.clientrender;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CRenderMapAddCommand extends AbstractS2CCommand<String>
{
    public S2CRenderMapAddCommand(Integer playerNetworkId, String mobId)
    {
        super(new String[]{ playerNetworkId.toString(), mobId });
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.CRAdd;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onClientMapAddCommand(this);
    }

    public boolean isValid()
    {
        return getArgumentAt(0) != null && getArgumentAt(1) != null;
    }

    public int getPlayerNetworkId()
    {
        if (!isValid()) throw new IllegalArgumentException("Trying to get a network id from an invalid packet.");

        return Integer.parseInt(getArgumentAt(0, "-1"));
    }

    public String getMobId()
    {
        if (!isValid()) throw new IllegalArgumentException("Trying to get mob id from an invalid packet.");

        return getArgumentAt(1, "morph:unknown");
    }

    private static final S2CRenderMapAddCommand invalidPacket = new S2CRenderMapAddCommand(-1, null);

    public static S2CRenderMapAddCommand of(Integer networkId, String mobId)
    {
        return new S2CRenderMapAddCommand(networkId, mobId);
    }

    public static S2CRenderMapAddCommand of(String arg)
    {
        var argSplit = arg.split(" ");

        if (argSplit.length < 2)
            return invalidPacket;

        int networkId = -1;

        try
        {
            networkId = Integer.parseInt(argSplit[0]);
        }
        catch (Throwable t)
        {
            return invalidPacket;
        }

        return S2CRenderMapAddCommand.of(networkId, argSplit[1]);
    }
}
