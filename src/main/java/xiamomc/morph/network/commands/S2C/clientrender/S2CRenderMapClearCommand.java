package xiamomc.morph.network.commands.S2C.clientrender;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CRenderMapClearCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.CRClear;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onClientMapClearCommand(this);
    }
}
