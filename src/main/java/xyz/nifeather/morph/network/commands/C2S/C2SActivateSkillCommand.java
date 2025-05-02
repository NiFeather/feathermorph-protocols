package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.Map;

public class C2SActivateSkillCommand extends AbstractC2SCommand<String>
{
    @Override
    public String getBaseName()
    {
        return C2SCommandNames.ActivateSkill;
    }

    public static C2SActivateSkillCommand fromArguments(Map<String, String> arguments)
    {
        return new C2SActivateSkillCommand();
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of();
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onSkillCommand(this);
    }
}
