package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CRenderMapRemoveCommand extends AbstractS2CCommand<Integer>
{
    private final int playerNetworkId;

    public S2CRenderMapRemoveCommand(Integer playerNetworkId)
    {
        this.playerNetworkId = playerNetworkId;
    }

    public static S2CRenderMapRemoveCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CRenderMapRemoveCommand(Integer.parseInt(Asserts.getStringOrThrow(arguments, "id")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "id", Integer.toString(playerNetworkId)
        );
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
        return playerNetworkId != -1;
    }

    public int getPlayerNetworkId()
    {
        if (!isValid()) throw new IllegalArgumentException("Trying to get a network id from an invalid packet.");

        return playerNetworkId;
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
