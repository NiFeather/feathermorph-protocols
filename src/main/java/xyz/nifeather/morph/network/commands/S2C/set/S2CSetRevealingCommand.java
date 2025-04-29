package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetRevealingCommand extends AbstractS2CSetCommand<Float>
{
    public S2CSetRevealingCommand(float val)
    {
        super(val);
    }

    public static S2CSetRevealingCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetRevealingCommand.class, 1);

        float value = Float.parseFloat(arguments.getFirst());
        if (Float.isInfinite(value) || Float.isNaN(value))
            throw new RuntimeException("The value for S2CSetRevealingCommand should be finite");

        return new S2CSetRevealingCommand(value);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetRevealing;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetRevealing(this);
    }

    public float getValue()
    {
        return getArgumentAt(0, 0f);
    }
}
