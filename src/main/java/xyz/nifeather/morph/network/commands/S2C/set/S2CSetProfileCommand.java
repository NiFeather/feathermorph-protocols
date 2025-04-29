package xyz.nifeather.morph.network.commands.S2C.set;

import org.jetbrains.annotations.NotNull;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CSetProfileCommand extends AbstractS2CSetCommand<String>
{
    private final String nbtTag;

    public S2CSetProfileCommand(@NotNull String nbtTag)
    {
        this.nbtTag = nbtTag;
    }

    public String getProfileSNbt()
    {
        return nbtTag;
    }

    public static S2CSetProfileCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetProfileCommand(Asserts.getStringOrThrow(arguments, "tag"));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("tag", nbtTag);
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
