package xyz.nifeather.morph.network.commands.S2C;

import org.jetbrains.annotations.ApiStatus;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

/**
 * Discard certain properties if they have previously been set.
 */
public class S2CDiscardPropertiesCommand extends AbstractS2CCommand<String>
{
    private final List<String> propertyNames;

    public List<String> propertyNames()
    {
        return List.copyOf(propertyNames);
    }

    public S2CDiscardPropertiesCommand(List<String> properties)
    {
        this.propertyNames = List.copyOf(properties);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.DiscardProperties;
    }

    @Override
    public void onCommand(BasicServerHandler<?> basicServerHandler)
    {
        basicServerHandler.onDiscardPropertiesCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "properties", gson().toJson(propertyNames)
        );
    }

    public static S2CDiscardPropertiesCommand fromArguments(Map<String, String> arguments)
            throws RuntimeException
    {
        var propertyList = Asserts.getStringOrThrow(arguments, "properties");
        var list = gson().fromJson(propertyList, List.class).stream().map(Object::toString).toList();

        return new S2CDiscardPropertiesCommand(list);
    }
}

