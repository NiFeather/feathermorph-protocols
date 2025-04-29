package xyz.nifeather.morph.network.commands.S2C.admin.reveal;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.MapCommandHelper;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

/**
 * Disguise UUID <-> Player Map Command
 */
public class S2CSetRenderRevealCommand extends AbstractS2CCommand<String>
{
    public S2CSetRenderRevealCommand(Map<Integer, String> uuidToPlayerMap)
    {
        super(gson().toJson(uuidToPlayerMap));
    }

    public static S2CSetRenderRevealCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CSetRenderRevealCommand.class, 1);

        return new S2CSetRenderRevealCommand(MapCommandHelper.parseMapIntegerString(arguments.getFirst()));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetReveal;
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

    public static S2CSetRenderRevealCommand of(Map<Integer, String> idToPlayerMap)
    {
        return new S2CSetRenderRevealCommand(idToPlayerMap);
    }

    public static S2CSetRenderRevealCommand ofStr(String arg)
    {
        return new S2CSetRenderRevealCommand(MapCommandHelper.parseMapIntegerString(arg));
    }
}
