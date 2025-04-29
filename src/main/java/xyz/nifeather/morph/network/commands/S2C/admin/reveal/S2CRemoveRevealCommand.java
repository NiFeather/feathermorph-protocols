package xyz.nifeather.morph.network.commands.S2C.admin.reveal;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CRemoveRevealCommand extends AbstractS2CCommand<Integer>
{
    public S2CRemoveRevealCommand(int id)
    {
        super(id);
    }

    public static S2CRemoveRevealCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CRemoveRevealCommand.class, 1);

        return new S2CRemoveRevealCommand(Integer.parseInt(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.RemoveReveal;
    }

    public int getTargetId()
    {
        return super.getArgumentAt(0, -1);
    }

    @Override
    public void onCommand(BasicServerHandler<?> listener)
    {
        listener.onMapRemoveCommand(this);
    }
}
