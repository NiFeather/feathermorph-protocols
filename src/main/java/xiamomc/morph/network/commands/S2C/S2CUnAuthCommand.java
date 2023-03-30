package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.BasicServerHandler;

public class S2CUnAuthCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.UnAuth;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onUnAuthCommand(this);
    }
}
