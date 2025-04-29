package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CSetProfileCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetProfileCommand(String nbtTag)
    {
        super(nbtTag);
    }

    public String getProfileSNbt()
    {
        return getArgumentAt(0, "{}");
    }

    public static S2CSetProfileCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetProfileCommand.class, 1);

        return new S2CSetProfileCommand(arguments.getFirst());
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetProfile;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetProfileCommand(this);
    }
}
