package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetSelfViewingCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetSelfViewingCommand(Boolean val)
    {
        super(val);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSelfViewing;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSelfViewingCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, true);
    }
}
