package xyz.nifeather.morph.network.commands.S2C.admin.reveal;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.Map;

public class S2CClearAdminRevealCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.ClearReveal;
    }

    public static S2CClearAdminRevealCommand fromArguments(Map<String, String> arguments)
    {
        return new S2CClearAdminRevealCommand();
    }

    public S2CClearAdminRevealCommand()
    {
        super();
    }

    @Override
    public void onCommand(BasicServerHandler<?> listener)
    {
        listener.onMapClearCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of();
    }
}
