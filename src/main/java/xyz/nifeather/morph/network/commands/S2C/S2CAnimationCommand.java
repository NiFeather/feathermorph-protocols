package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CAnimationCommand extends AbstractS2CCommand<String>
{
    public S2CAnimationCommand(String animation)
    {
        super(animation);
    }

    public static S2CAnimationCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CAnimationCommand.class, 1);
        return new S2CAnimationCommand(arguments.getFirst());
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
