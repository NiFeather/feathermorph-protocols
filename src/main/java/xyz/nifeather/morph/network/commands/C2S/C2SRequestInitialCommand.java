package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.List;
import java.util.Map;

public class C2SRequestInitialCommand extends AbstractC2SCommand<String>
{
    public static C2SRequestInitialCommand fromArguments(Map<String, String> arguments)
    {
        return new C2SRequestInitialCommand();
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of();
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.Initial;
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onInitialCommand(this);
    }
}
