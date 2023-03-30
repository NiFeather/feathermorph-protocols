package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSwapCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName() {
        return "swap";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSwapCommand(this);
    }
}
