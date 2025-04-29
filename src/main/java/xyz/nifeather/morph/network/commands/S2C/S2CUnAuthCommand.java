package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.List;
import java.util.Map;

public class S2CUnAuthCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.UnAuth;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onUnAuthCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of();
    }

    public static S2CUnAuthCommand fromArguments(Map<String, String> arguments)
    {
        return new S2CUnAuthCommand();
    }
}
