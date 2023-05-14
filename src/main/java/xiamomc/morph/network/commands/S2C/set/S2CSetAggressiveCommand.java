package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetAggressiveCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetAggressiveCommand(boolean val)
    {
        super(val);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetAggressive;
    }

    @Environment(EnvironmentType.CLIENT)
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
