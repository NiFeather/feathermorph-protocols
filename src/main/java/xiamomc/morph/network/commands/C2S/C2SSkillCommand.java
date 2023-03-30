package xiamomc.morph.network.commands.C2S;

import xiamomc.morph.network.BasicClientHandler;

public class C2SSkillCommand extends AbstractC2SCommand<String>
{
    @Override
    public String getBaseName()
    {
        return C2SCommandNames.Skill;
    }

    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onSkillCommand(this);
    }
}
