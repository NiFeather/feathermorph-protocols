package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CSetSneakingCommand extends AbstractS2CSetCommand<Boolean>
{
    public final boolean sneaking;

    public S2CSetSneakingCommand(boolean val)
    {
        this.sneaking = val;
    }

    public static S2CSetSneakingCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetSneakingCommand(Boolean.parseBoolean(Asserts.getStringOrThrow(arguments, "sneaking")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("sneaking", sneaking + "");
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSneaking;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSneakingCommand(this);
    }
}
