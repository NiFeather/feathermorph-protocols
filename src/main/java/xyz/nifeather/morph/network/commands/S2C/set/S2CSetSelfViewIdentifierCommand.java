package xyz.nifeather.morph.network.commands.S2C.set;

import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CSetSelfViewIdentifierCommand extends AbstractS2CSetCommand<String>
{
    @Nullable
    private final String identifier;

    @Nullable
    public String getIdentifier()
    {
        return "~nil".equals(identifier) ? null : identifier;
    }

    public S2CSetSelfViewIdentifierCommand(@Nullable String identifier)
    {
        this.identifier = identifier;
    }

    public static S2CSetSelfViewIdentifierCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetSelfViewIdentifierCommand(Asserts.getStringOrThrow(arguments, "current"));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("current", identifier == null ? "~nil" : identifier);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSelfViewIdentifier;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSelfViewIdentifierCommand(this);
    }
}
