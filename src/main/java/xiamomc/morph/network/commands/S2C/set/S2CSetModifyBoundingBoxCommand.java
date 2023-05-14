package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

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

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + getModifyBoundingBox();
    }
}
