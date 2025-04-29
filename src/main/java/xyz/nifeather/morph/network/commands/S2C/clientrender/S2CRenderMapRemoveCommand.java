package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CRenderMapRemoveCommand extends AbstractS2CCommand<Integer>
{
    public S2CRenderMapRemoveCommand(Integer playerNetworkId)
    {
        super(playerNetworkId);
    }

    public static S2CRenderMapRemoveCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CRenderMapRemoveCommand.class, 1);

        return new S2CRenderMapRemoveCommand(Integer.parseInt(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.CRRemove;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onClientMapRemoveCommand(this);
    }

    public boolean isValid()
    {
        return getArgumentAt(0, -1) != -1;
    }

    public int getPlayerNetworkId()
    {
        if (!isValid()) throw new IllegalArgumentException("Trying to get a network id from an invalid packet.");

        return getArgumentAt(0, -1);
    }

    private static final S2CRenderMapRemoveCommand invalidPacket = new S2CRenderMapRemoveCommand(-1);

    public static S2CRenderMapRemoveCommand of(Integer networkId)
    {
        return new S2CRenderMapRemoveCommand(networkId);
    }

    public static S2CRenderMapRemoveCommand of(String arg)
    {
        var argSplit = arg.split(" ");

        int networkId = -1;

        try
        {
            networkId = Integer.parseInt(argSplit[0]);
        }
        catch (Throwable t)
        {
            return invalidPacket;
        }

        return S2CRenderMapRemoveCommand.of(networkId);
    }
}
