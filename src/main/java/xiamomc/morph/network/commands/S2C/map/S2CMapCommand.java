package xiamomc.morph.network.commands.S2C.map;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Disguise UUID <-> Player Map Command
 */
public class S2CMapCommand extends AbstractS2CCommand<String>
{
    public S2CMapCommand(Map<Integer, String> uuidToPlayerMap)
    {
        super(gson().toJson(uuidToPlayerMap));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.Map;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onMapCommand(this);
    }

    private static final String defaultMapStr = "{}";

    public Map<Integer, String> getMap()
    {
        var arg = this.getArgumentAt(0, defaultMapStr);

        if (arg.equals(defaultMapStr)) return new HashMap<>();
        var mapConv = gson().fromJson(arg, HashMap.class);

        var map = new HashMap<Integer, String>();
        mapConv.forEach((k, v) ->
        {
            try
            {
                var uuid = Integer.parseInt(k.toString());

                map.put(uuid, v.toString());
            }
            catch (Throwable t)
            {
                System.out.println("Unable to convert %s to Integer ID: %s".formatted(k, t.getMessage()));
            }
        });

        return map;
    }

    public static S2CMapCommand of(Map<Integer, String> uuidToPlayerMap)
    {
        return new S2CMapCommand(uuidToPlayerMap);
    }

    public static S2CMapCommand ofStr(String arg)
    {
        if (arg.equals(defaultMapStr)) return new S2CMapCommand(new HashMap<>());
        var mapConv = gson().fromJson(arg, HashMap.class);

        var map = new HashMap<Integer, String>();
        mapConv.forEach((k, v) ->
        {
            try
            {
                var uuid = Integer.parseInt(k.toString());

                map.put(uuid, v.toString());
            }
            catch (Throwable t)
            {
                System.out.println("Unable to convert %s to UUID: %s".formatted(k, t.getMessage()));
            }
        });

        return new S2CMapCommand(map);
    }
}
