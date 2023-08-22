package xiamomc.morph.network.commands.S2C.map;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.C2S.AbstractC2SCommand;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

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
