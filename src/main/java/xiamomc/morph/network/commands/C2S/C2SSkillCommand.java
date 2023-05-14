package xiamomc.morph.network.commands.C2S;

import xiamomc.morph.network.BasicClientHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;

public class C2SSkillCommand extends AbstractC2SCommand<String>
{
    @Override
    public String getBaseName()
    {
        return C2SCommandNames.Skill;
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onSkillCommand(this);
    }
}
