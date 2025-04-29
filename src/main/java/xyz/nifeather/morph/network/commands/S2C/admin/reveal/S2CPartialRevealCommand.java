package xyz.nifeather.morph.network.commands.S2C.admin.reveal;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.MapCommandHelper;
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
    private final Map<Integer, String> uuidPlayerMap;

    public S2CPartialRevealCommand(Map<Integer, String> uuidToPlayerMap)
    {
        this.uuidPlayerMap = uuidToPlayerMap;
    }

    public static S2CPartialRevealCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CPartialRevealCommand(MapCommandHelper.parseMapIntegerString(Asserts.getStringOrThrow(arguments, "value")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "value", gson().toJson(uuidPlayerMap)
        );
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

    public Map<Integer, String> getMap()
    {
        return uuidPlayerMap;
    }

    public static S2CPartialRevealCommand of(Map<Integer, String> uuidToPlayerMap)
    {
        return new S2CPartialRevealCommand(uuidToPlayerMap);
    }
}
