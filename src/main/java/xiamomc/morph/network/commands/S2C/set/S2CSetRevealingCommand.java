package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetRevealingCommand extends AbstractS2CSetCommand<Float>
{
    public S2CSetRevealingCommand(float val)
    {
        super(val);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetRevealing;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetRevealing(this);
    }

    public float getValue()
    {
        return getArgumentAt(0, 0f);
    }
}
