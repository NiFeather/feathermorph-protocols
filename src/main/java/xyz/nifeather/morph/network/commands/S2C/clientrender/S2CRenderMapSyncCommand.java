package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.MapCommandHelper;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CRenderMapSyncCommand extends AbstractS2CCommand<String>
{
    public S2CRenderMapSyncCommand(Map<Integer, String> uuidToPlayerMap)
    {
        super(gson().toJson(uuidToPlayerMap));
    }

    public static S2CRenderMapSyncCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CRenderMapSyncCommand.class, 1);

        return new S2CRenderMapSyncCommand(MapCommandHelper.parseMapIntegerString(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.CRMap;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onClientMapSyncCommand(this);
    }

    public Map<Integer, String> getMap()
    {
        return MapCommandHelper.parseMapIntegerString(this);
    }

    public static S2CRenderMapSyncCommand of(Map<Integer, String> idToPlayerMap)
    {
        return new S2CRenderMapSyncCommand(idToPlayerMap);
    }

    public static S2CRenderMapSyncCommand ofStr(String arg)
    {
        return new S2CRenderMapSyncCommand(MapCommandHelper.parseMapIntegerString(arg));
    }
}
