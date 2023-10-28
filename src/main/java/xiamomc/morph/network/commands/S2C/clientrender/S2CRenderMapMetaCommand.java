package xiamomc.morph.network.commands.S2C.clientrender;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CRenderMapMetaCommand extends AbstractS2CCommand<S2CRenderMeta>
{
    public S2CRenderMapMetaCommand(S2CRenderMeta meta)
    {
        super(meta);
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

