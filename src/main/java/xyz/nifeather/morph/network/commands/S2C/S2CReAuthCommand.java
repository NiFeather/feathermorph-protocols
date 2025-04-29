package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.List;
import java.util.Map;

public class S2CReAuthCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.ReAuth;
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of();
    }

    public static S2CReAuthCommand fromArguments(Map<String, String> arguments)
    {
        return new S2CReAuthCommand();
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onReAuthCommand(this);
    }
}
