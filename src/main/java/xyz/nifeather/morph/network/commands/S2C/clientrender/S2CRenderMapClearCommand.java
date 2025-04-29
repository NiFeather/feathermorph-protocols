package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.List;
import java.util.Map;

public class S2CRenderMapClearCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.CRClear;
    }

    public static S2CRenderMapClearCommand fromArguments(Map<String, String> arguments)
    {
        return new S2CRenderMapClearCommand();
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onClientMapClearCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of();
    }
}
