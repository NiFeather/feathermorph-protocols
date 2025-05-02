package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CPlayAnimationCommand extends AbstractS2CCommand<String>
{
    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("anim_identifier", animationIdentifier);
    }

    private final String animationIdentifier;

    public S2CPlayAnimationCommand(String animationIdentifier)
    {
        this.animationIdentifier = animationIdentifier;
    }

    public static S2CPlayAnimationCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CPlayAnimationCommand(Asserts.getStringOrThrow(arguments, "anim_identifier"));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.PlayAnimation;
    }

    public String getAnimId()
    {
        return animationIdentifier;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onAnimationCommand(this);
    }
}
