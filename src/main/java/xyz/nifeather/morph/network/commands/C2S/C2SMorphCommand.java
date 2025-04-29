package xyz.nifeather.morph.network.commands.C2S;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class C2SMorphCommand extends AbstractC2SCommand<String>
{
    @NotNull
    private final String identifier;

    public String identifier()
    {
        return identifier;
    }

    public C2SMorphCommand(@Nullable String identifier)
    {
        this.identifier = identifier == null ? "" : identifier;
    }

    public static C2SMorphCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new C2SMorphCommand(Asserts.getStringOrThrow(arguments, "id"));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "id", identifier
        );
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.Morph;
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onMorphCommand(this);
    }
}
