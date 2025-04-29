package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CSetSkillCooldownCommand extends AbstractS2CSetCommand<Long>
{
    public final long val;

    public S2CSetSkillCooldownCommand(long value)
    {
        this.val = value;
    }

    public static S2CSetSkillCooldownCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetSkillCooldownCommand(Long.parseLong(Asserts.getStringOrThrow(arguments, "val")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("val", Long.toString(val));
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
