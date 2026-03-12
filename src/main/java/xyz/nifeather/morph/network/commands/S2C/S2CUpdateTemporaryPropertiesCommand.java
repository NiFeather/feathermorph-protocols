package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Update temporary properties, properties updated via this command should not be saved when saving the disguise.
 */
public class S2CUpdateTemporaryPropertiesCommand extends S2CUpdatePropertiesCommand
{
    public S2CUpdateTemporaryPropertiesCommand(Map<String, String> properties)
    {
        super(properties);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.UpdateTemporaryProperties;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onUpdateTemporaryPropertiesCommand(this);
    }

    public static S2CUpdateTemporaryPropertiesCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var propertyMapString = Asserts.getStringOrThrow(arguments, "properties");
        Map<?,?> propertyMap = gson().fromJson(propertyMapString, Map.class);

        // Convert so that the map given to the instance is correctly setup with String <-> String
        var convertedMap = new HashMap<String, String>();
        propertyMap.forEach((key, val) -> convertedMap.put("" + key, "" + val));

        return new S2CUpdateTemporaryPropertiesCommand(convertedMap);
    }
}
