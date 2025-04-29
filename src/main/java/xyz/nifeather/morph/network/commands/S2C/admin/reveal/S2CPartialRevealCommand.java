package xyz.nifeather.morph.network.commands.S2C.admin.reveal;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Disguise UUID <-> Player Map Command
 */
public class S2CPartialRevealCommand extends AbstractS2CCommand<String>
{
    public S2CPartialRevealCommand(Map<Integer, String> uuidToPlayerMap)
    {
        super(gson().toJson(uuidToPlayerMap));
    }

    public static S2CPartialRevealCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CPartialRevealCommand.class, 1);

        return ofStr(arguments.getFirst());
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.AddReveal;
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

    public static S2CPartialRevealCommand of(Map<Integer, String> uuidToPlayerMap)
    {
        return new S2CPartialRevealCommand(uuidToPlayerMap);
    }

    public static S2CPartialRevealCommand ofStr(String arg)
    {
        if (arg.equals(defaultMapStr)) return new S2CPartialRevealCommand(new HashMap<>());
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

        return new S2CPartialRevealCommand(map);
    }
}
