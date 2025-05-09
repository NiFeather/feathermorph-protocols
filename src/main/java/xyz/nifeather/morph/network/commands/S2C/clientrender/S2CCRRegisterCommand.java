package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CCRRegisterCommand extends AbstractS2CCommand<String>
{
    private int networkId;
    private String mobId;

    public S2CCRRegisterCommand(Integer playerNetworkId, String mobId)
    {
        this.networkId = playerNetworkId;
        this.mobId = mobId;
    }

    public static S2CCRRegisterCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CCRRegisterCommand(
                Integer.parseInt(Asserts.getStringOrThrow(arguments, "player_id")),
                Asserts.getStringOrThrow(arguments, "mob_id")
        );
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "player_id", Integer.toString(networkId),
                "mob_id", mobId
        );
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
        return !mobId.isBlank();
    }

    public int getPlayerNetworkId()
    {
        if (!isValid()) throw new IllegalArgumentException("Trying to get a network id from an invalid packet.");

        return networkId;
    }

    public String getMobId()
    {
        if (!isValid()) throw new IllegalArgumentException("Trying to get mob id from an invalid packet.");

        return mobId;
    }

    private static final S2CCRRegisterCommand invalidPacket = new S2CCRRegisterCommand(-1, null);

    public static S2CCRRegisterCommand of(Integer networkId, String mobId)
    {
        return new S2CCRRegisterCommand(networkId, mobId);
    }

    public static S2CCRRegisterCommand of(String arg)
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

        return S2CCRRegisterCommand.of(networkId, argSplit[1]);
    }
}
