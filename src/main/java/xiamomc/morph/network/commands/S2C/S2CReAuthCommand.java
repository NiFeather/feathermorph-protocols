package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.BasicServerHandler;

public class S2CReAuthCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName() {
        return "reauth";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onReAuthCommand(this);
    }
}
