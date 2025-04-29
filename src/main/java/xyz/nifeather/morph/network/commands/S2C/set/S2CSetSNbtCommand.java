package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CSetSNbtCommand extends AbstractS2CSetCommand<String>
{
    private final String tag;

    public S2CSetSNbtCommand(String tag)
    {
        this.tag = tag;
    }

    public String getSNbt()
    {
        return tag;
    }

    public static S2CSetSNbtCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetSNbtCommand(Asserts.getStringOrThrow(arguments, "tag"));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("tag", tag);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSNbt;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSNbtCommand(this);
    }
}
