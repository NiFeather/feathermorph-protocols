package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

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
