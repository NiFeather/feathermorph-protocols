package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class C2SAnimationCommand extends AbstractC2SCommand<String>
{
    public C2SAnimationCommand(String animationId)
    {
        super(animationId);
    }

    public static C2SAnimationCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, C2SAnimationCommand.class, 1);
        return new C2SAnimationCommand(arguments.getFirst());
    }

    @Override
    public String getBaseName()
    {
        return "animation";
    }

    public static final String UNKNOWN_ANIMATION_ID = "morph:unknown";

    public String getAnimationId()
    {
        return getArgumentAt(0, UNKNOWN_ANIMATION_ID);
    }

    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onAnimationCommand(this);
    }
}
