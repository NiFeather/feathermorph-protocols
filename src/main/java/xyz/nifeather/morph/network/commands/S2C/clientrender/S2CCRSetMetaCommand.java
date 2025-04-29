package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CCRSetMetaCommand extends AbstractS2CCommand<S2CRenderMeta>
{
    public final S2CRenderMeta renderMeta;

    public S2CCRSetMetaCommand(S2CRenderMeta meta)
    {
        this.renderMeta = meta;
    }

    public static S2CCRSetMetaCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CCRSetMetaCommand(S2CRenderMeta.fromString(Asserts.getStringOrThrow(arguments, "rendermeta")));
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.CRMeta;
    }

    @Override
    public void onCommand(BasicServerHandler<?> listener)
    {
        listener.onClientMapMetaNbtCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "rendermeta", renderMeta.toString()
        );
    }

    public static S2CCRSetMetaCommand fromStr(String arg)
    {
        var meta = S2CRenderMeta.fromString(arg);
        return new S2CCRSetMetaCommand(meta);
    }
}

