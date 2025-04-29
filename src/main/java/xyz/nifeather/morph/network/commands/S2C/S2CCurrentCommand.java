package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CCurrentCommand extends AbstractS2CCommand<String>
{
    public S2CCurrentCommand(String identifier)
    {
        super(identifier);
    }

    public String getDisguiseIdentifier()
    {
        return getArgumentAt(0, "null");
    }

    public static S2CCurrentCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CCurrentCommand.class, 1);
        return new S2CCurrentCommand(arguments.getFirst());
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.Current;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onCurrentCommand(this);
    }
}
