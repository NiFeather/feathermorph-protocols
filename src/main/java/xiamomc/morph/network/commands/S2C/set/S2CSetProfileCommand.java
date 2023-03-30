package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public class S2CSetProfileCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetProfileCommand(String nbtTag)
    {
        super(nbtTag);
    }

    @Override
    public String getBaseName()
    {
        return "profile";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetProfileCommand(this);
    }

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, "{}");
    }
}
