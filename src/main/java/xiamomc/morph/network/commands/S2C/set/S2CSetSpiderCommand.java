package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

/**
 * 已弃用
 */
@Deprecated
public class S2CSetSpiderCommand extends AbstractS2CSetCommand<Boolean>
{
    public S2CSetSpiderCommand(boolean isSpider)
    {
        super(isSpider);
    }

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

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + serializeArguments();
    }
}
