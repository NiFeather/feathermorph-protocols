package xyz.nifeather.morph.network.commands.S2C;

import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CCurrentCommand extends AbstractS2CCommand<String>
{
    @Nullable
    private final String disguiseIdentifier;

    public S2CCurrentCommand(@Nullable String identifier)
    {
        this.disguiseIdentifier = identifier;
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("identifier", disguiseIdentifier == null ? "~nil" : disguiseIdentifier);
    }

    @Nullable
    public String getDisguiseIdentifier()
    {
        return disguiseIdentifier;
    }

    public static S2CCurrentCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var id = Asserts.getStringOrThrow(arguments, "identifier");
        if (id.equals("~nil"))
            id = null;

        return new S2CCurrentCommand(id);
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
