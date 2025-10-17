package xyz.nifeather.morph.network.commands.C2S;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class C2SMorphCommand extends AbstractC2SCommand<String>
{
    @NotNull
    private final String identifier;

    public String identifier()
    {
        return identifier;
    }

    private final Map<String, String> properties = new ConcurrentHashMap<>();

    public Map<String, String> propertyInputs()
    {
        return Map.copyOf(properties);
    }

    public C2SMorphCommand(@Nullable String identifier, Map<String, String> propertyInputs)
    {
        this.identifier = identifier == null ? "" : identifier;
        this.properties.putAll(propertyInputs);
    }

    private static final Gson gson = new GsonBuilder().create();

    public static C2SMorphCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        Map<String, String> properties = new HashMap<>();

        if (arguments.containsKey("properties"))
        {
            gson.fromJson(Asserts.getStringOrThrow(arguments, "properties"), Map.class)
                    .forEach((k, v) -> properties.put("" + k, "" + v));
        }

        return new C2SMorphCommand(Asserts.getStringOrThrow(arguments, "id"), properties);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "id", identifier,
                "properties", gson.toJson(properties)
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
