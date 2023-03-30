package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSetToggleSelfCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetToggleSelfCommand(Boolean val)
    {
        super(val);
    }

    @Override
    public String getBaseName()
    {
        return "toggleself";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetToggleSelfCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, true);
    }
}
