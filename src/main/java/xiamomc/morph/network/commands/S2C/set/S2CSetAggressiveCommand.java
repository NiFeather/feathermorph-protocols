package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSetAggressiveCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetAggressiveCommand(boolean val)
    {
        super(val);
    }

    @Override
    public String getBaseName()
    {
        return "aggressive";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetAggressiveCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + getArgumentAt(0, false);
    }
}
