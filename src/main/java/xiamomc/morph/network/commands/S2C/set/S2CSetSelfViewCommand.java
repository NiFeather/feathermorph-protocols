package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSetSelfViewCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetSelfViewCommand(String identifier)
    {
        super(identifier);
    }

    @Override
    public String getBaseName()
    {
        return "selfview";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSelfViewCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, "");
    }
}
