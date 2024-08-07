package xiamomc.morph.network.commands.C2S;

import xiamomc.morph.network.BasicClientHandler;

public class C2SAnimationCommand extends AbstractC2SCommand<String>
{
    public C2SAnimationCommand(String animationId)
    {
        super(animationId);
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
