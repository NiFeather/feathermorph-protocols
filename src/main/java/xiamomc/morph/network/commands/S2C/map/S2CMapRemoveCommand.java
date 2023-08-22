package xiamomc.morph.network.commands.S2C.map;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CMapRemoveCommand extends AbstractS2CCommand<Integer>
{
    public S2CMapRemoveCommand(int id)
    {
        super(id);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.MapRemove;
    }

    public int getTargetId()
    {
        return super.getArgumentAt(0, -1);
    }

    @Override
    public void onCommand(BasicServerHandler<?> listener)
    {
        listener.onMapRemoveCommand(this);
    }
}
