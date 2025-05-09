package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class C2SRequestAnimationCommand extends AbstractC2SCommand<String>
{
    private final String animId;

    public C2SRequestAnimationCommand(String animationId)
    {
        this.animId = animationId;
    }

    public static C2SRequestAnimationCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new C2SRequestAnimationCommand(Asserts.getStringOrThrow(arguments, "anim"));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "anim", animId
        );
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.RequestAnimation;
    }

    public static final String UNKNOWN_ANIMATION_ID = "morph:unknown";

    public String getAnimationId()
    {
        return animId;
    }

    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onAnimationCommand(this);
    }
}
