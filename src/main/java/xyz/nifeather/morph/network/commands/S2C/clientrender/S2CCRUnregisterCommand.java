package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CCRUnregisterCommand extends AbstractS2CCommand<Integer>
{
    private final int playerNetworkId;

    public S2CCRUnregisterCommand(Integer playerNetworkId)
    {
        this.playerNetworkId = playerNetworkId;
    }

    public static S2CCRUnregisterCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CCRUnregisterCommand(Integer.parseInt(Asserts.getStringOrThrow(arguments, "id")));
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

    private static final S2CCRUnregisterCommand invalidPacket = new S2CCRUnregisterCommand(-1);

    public static S2CCRUnregisterCommand of(Integer networkId)
    {
        return new S2CCRUnregisterCommand(networkId);
    }

    public static S2CCRUnregisterCommand of(String arg)
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

        return S2CCRUnregisterCommand.of(networkId);
    }
}
