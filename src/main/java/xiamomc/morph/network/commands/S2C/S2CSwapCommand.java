package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;

public class S2CSwapCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName() {
        return S2CCommandNames.SwapHands;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSwapCommand(this);
    }
}
