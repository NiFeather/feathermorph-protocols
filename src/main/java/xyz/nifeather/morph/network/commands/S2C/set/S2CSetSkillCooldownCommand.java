package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetSkillCooldownCommand extends AbstractS2CSetCommand<Long>
{
    public S2CSetSkillCooldownCommand(long value)
    {
        super(value);
    }

    public static S2CSetSkillCooldownCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetSkillCooldownCommand.class, 1);

        return new S2CSetSkillCooldownCommand(Long.parseLong(arguments.getFirst()));
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
