package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetSelfViewingCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetSelfViewingCommand(Boolean val)
    {
        super(val);
    }

    public static S2CSetSelfViewingCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetSelfViewingCommand.class, 1);

        return new S2CSetSelfViewingCommand(Boolean.parseBoolean(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSelfViewing;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSelfViewingCommand(this);
    }
}
