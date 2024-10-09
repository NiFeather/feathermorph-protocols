package xyz.nifeather.morph.network.commands.S2C.map;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.C2S.AbstractC2SCommand;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.Map;

public class S2CMapClearCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.MapClear;
    }

    public S2CMapClearCommand()
    {
        super(S2CCommandNames.MapClear);
    }

    @Override
    public void onCommand(BasicServerHandler<?> listener)
    {
        listener.onMapClearCommand(this);
    }
}
