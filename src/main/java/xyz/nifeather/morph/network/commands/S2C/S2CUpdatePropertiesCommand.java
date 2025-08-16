package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class S2CUpdatePropertiesCommand extends AbstractS2CCommand<String>
{
    private final Map<String, String> properties = new ConcurrentHashMap<>();

    public Map<String, String> getProperties()
    {
        return properties;
    }

    public S2CUpdatePropertiesCommand(Map<String, String> properties)
    {
        this.properties.putAll(properties);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.UpdateProperties;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onUpdatePropertiesCommand(this);
    }

    public static S2CUpdatePropertiesCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var propertyMapString = Asserts.getStringOrThrow(arguments, "properties");
        Map<?,?> propertyMap = gson().fromJson(propertyMapString, Map.class);

        // Convert so that the map given to the instance is correctly setup with String <-> String
        var convertedMap = new HashMap<String, String>();
        propertyMap.forEach((key, val) -> convertedMap.put("" + key, "" + val));

        return new S2CUpdatePropertiesCommand(convertedMap);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "properties", gson().toJson(properties)
        );
    }
}
