package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CSetMobRevealCommand extends AbstractS2CSetCommand<Float>
{
    private final float val;

    public S2CSetMobRevealCommand(float val)
    {
        this.val = val;
    }

    public static S2CSetMobRevealCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        float value = Float.parseFloat(Asserts.getStringOrThrow(arguments, "val"));
        if (Float.isInfinite(value) || Float.isNaN(value))
            throw new RuntimeException("The value for S2CSetRevealingCommand should be finite");

        return new S2CSetMobRevealCommand(value);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("val", Float.toString(val));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetMobReveal;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetRevealing(this);
    }

    public float getValue()
    {
        return val;
    }
}
