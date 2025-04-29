package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.List;

public class S2CSetAggressiveCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetAggressiveCommand(boolean val)
    {
        super(val);
    }

    public static S2CSetAggressiveCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        if (arguments.isEmpty())
            throw new RuntimeException("At least one argument is required for S2CSetAggressiveCommand, but got empty");

        return new S2CSetAggressiveCommand(Boolean.parseBoolean(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetAggressive;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetAggressiveCommand(this);
    }
}
