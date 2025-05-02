package xyz.nifeather.morph.network.commands.S2C.admin.reveal;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CRemoveAdminRevealCommand extends AbstractS2CCommand<Integer>
{
    private final int playerNetworkId;

    public S2CRemoveAdminRevealCommand(int id)
    {
        this.playerNetworkId = id;
    }

    public static S2CRemoveAdminRevealCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CRemoveAdminRevealCommand(Integer.parseInt(Asserts.getStringOrThrow(arguments, "id")));
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
        return S2CCommandNames.AdminRevealRemove;
    }

    public int getTargetId()
    {
        return playerNetworkId;
    }

    @Override
    public void onCommand(BasicServerHandler<?> listener)
    {
        listener.onMapRemoveCommand(this);
    }
}
