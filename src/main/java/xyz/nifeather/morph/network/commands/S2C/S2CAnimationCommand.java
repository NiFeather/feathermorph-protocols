package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;

public class S2CAnimationCommand extends AbstractS2CCommand<String>
{
    public S2CAnimationCommand(String animation)
    {
        super(animation);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.Animation;
    }

    public String getAnimId()
    {
        return getArgumentAt(0, "nil");
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onAnimationCommand(this);
    }
}
