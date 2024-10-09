package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetSkillCooldownCommand extends AbstractS2CSetCommand<Long>
{
    public S2CSetSkillCooldownCommand(long value)
    {
        super(value);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSkillCooldown;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSkillCooldownCommand(this);
    }
}
