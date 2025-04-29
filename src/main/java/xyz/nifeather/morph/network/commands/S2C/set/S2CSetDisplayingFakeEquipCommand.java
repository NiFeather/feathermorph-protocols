package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.commands.S2C.S2CRequestCommand;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetDisplayingFakeEquipCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetDisplayingFakeEquipCommand(boolean val)
    {
        super(val);
    }

    public static S2CSetDisplayingFakeEquipCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetDisplayingFakeEquipCommand.class, 1);

        return new S2CSetDisplayingFakeEquipCommand(Boolean.parseBoolean(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetDisplayingFakeEquip;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetDisplayingFakeEquipCommand(this);
    }
}
