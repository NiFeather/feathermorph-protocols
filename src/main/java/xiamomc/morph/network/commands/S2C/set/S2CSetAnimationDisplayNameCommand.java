package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetAnimationDisplayNameCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetAnimationDisplayNameCommand(String id)
    {
        super(id);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetAnimationDisplayName;
    }

    public String getDisplayIdentifier()
    {
        return getArgumentAt(0, "nil");
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetAnimationDisplayCommand(this);
    }
}
