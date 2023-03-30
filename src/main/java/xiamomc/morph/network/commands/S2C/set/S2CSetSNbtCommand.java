package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetSNbtCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetSNbtCommand(String tag)
    {
        super(tag);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSNbt;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSNbtCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, "{}");
    }
}
