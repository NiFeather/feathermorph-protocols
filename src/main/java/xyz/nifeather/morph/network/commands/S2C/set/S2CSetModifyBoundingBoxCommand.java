package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetModifyBoundingBoxCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetModifyBoundingBoxCommand(boolean val)
    {
        super(val);
    }

    public boolean getModifyBoundingBox()
    {
        return getArgumentAt(0, false);
    }

    public static S2CSetModifyBoundingBoxCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetModifyBoundingBoxCommand.class, 1);

        return new S2CSetModifyBoundingBoxCommand(Boolean.parseBoolean(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetModifyBoundingBox;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetModifyBoundingBox(this);
    }
}
