package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSetFakeEquipCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetFakeEquipCommand(boolean val)
    {
        super(val);
    }

    @Override
    public String getBaseName()
    {
        return "fake_equip";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetFakeEquipCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, false);
    }
}
