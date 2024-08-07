package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.BasicServerHandler;

public class S2CAnimationCommand extends AbstractS2CCommand<String>
{
    public S2CAnimationCommand(String animation)
    {
        super(animation);
    }

    @Override
    public String getBaseName()
    {
        return "animation";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onAnimationCommand(this);
    }
}
