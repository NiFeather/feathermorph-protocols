package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSetSkillCooldownCommand extends AbstractS2CSetCommand<Long>
{
    public S2CSetSkillCooldownCommand(long value)
    {
        super(value);
    }

    @Override
    public String getBaseName()
    {
        return "cd";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSkillCooldownCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + getArgumentAt(0, 0L);
    }
}
