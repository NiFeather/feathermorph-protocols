package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetDisplayingFakeEquipCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetDisplayingFakeEquipCommand(boolean val)
    {
        super(val);
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

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, false);
    }
}
