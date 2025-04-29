package xyz.nifeather.morph.network.commands.S2C.clientrender;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;

public class S2CRenderMapMetaCommand extends AbstractS2CCommand<S2CRenderMeta>
{
    public S2CRenderMapMetaCommand(S2CRenderMeta meta)
    {
        super(meta);
    }

    public static S2CRenderMapMetaCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CRenderMapMetaCommand.class, 1);

        return new S2CRenderMapMetaCommand(S2CRenderMeta.fromString(arguments.getFirst()));
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

    public static S2CRenderMapMetaCommand fromStr(String arg)
    {
        var meta = S2CRenderMeta.fromString(arg);
        return new S2CRenderMapMetaCommand(meta);
    }
}

