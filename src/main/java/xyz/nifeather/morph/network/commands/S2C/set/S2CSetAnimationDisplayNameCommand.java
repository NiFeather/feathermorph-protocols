package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.commands.S2C.S2CRequestCommand;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetAnimationDisplayNameCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetAnimationDisplayNameCommand(String translateId)
    {
        super(translateId);
    }

    public static S2CSetAnimationDisplayNameCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetAnimationDisplayNameCommand.class, 1);

        return new S2CSetAnimationDisplayNameCommand(arguments.getFirst());
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetAnimationDisplayName;
    }

    public String getDisplayIdentifier()
    {
        return getArgumentAt(0, "nil");
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetAnimationDisplayCommand(this);
    }
}
