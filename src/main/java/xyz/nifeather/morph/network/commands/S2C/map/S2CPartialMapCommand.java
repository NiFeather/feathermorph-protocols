package xyz.nifeather.morph.network.commands.S2C.map;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.HashMap;
import java.util.Map;

/**
 * Disguise UUID <-> Player Map Command
 */
public class S2CPartialMapCommand extends AbstractS2CCommand<String>
{
    public S2CPartialMapCommand(Map<Integer, String> uuidToPlayerMap)
    {
        super(gson().toJson(uuidToPlayerMap));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.MapPartial;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onMapPartialCommand(this);
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

    public static S2CPartialMapCommand of(Map<Integer, String> uuidToPlayerMap)
    {
        return new S2CPartialMapCommand(uuidToPlayerMap);
    }

    public static S2CPartialMapCommand ofStr(String arg)
    {
        if (arg.equals(defaultMapStr)) return new S2CPartialMapCommand(new HashMap<>());
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

        return new S2CPartialMapCommand(map);
    }
}
