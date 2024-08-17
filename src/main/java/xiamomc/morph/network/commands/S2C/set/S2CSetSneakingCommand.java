package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetSneakingCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetSneakingCommand(boolean val)
    {
        super(val);
    }
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSneaking;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSneakingCommand(this);
    }
}
