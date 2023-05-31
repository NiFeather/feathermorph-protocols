package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetSpiderCommand extends AbstractS2CSetCommand<Boolean>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSpider;
    }

    public boolean value()
    {
        return getArgumentAt(0, false);
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSpider(this);
    }
}
