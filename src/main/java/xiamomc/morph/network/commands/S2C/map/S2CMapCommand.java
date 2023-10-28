package xiamomc.morph.network.commands.S2C.map;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.MapCommandHelper;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

import java.util.HashMap;
import java.util.Map;

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

    public Map<Integer, String> getMap()
    {
        return MapCommandHelper.parseMapIntegerString(this);
    }

    public static S2CMapCommand of(Map<Integer, String> idToPlayerMap)
    {
        return new S2CMapCommand(idToPlayerMap);
    }

    public static S2CMapCommand ofStr(String arg)
    {
        return new S2CMapCommand(MapCommandHelper.parseMapIntegerString(arg));
    }
}
