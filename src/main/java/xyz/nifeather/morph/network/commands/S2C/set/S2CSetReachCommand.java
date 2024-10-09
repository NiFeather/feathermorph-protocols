package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetReachCommand extends AbstractS2CSetCommand<Integer>
{
    public S2CSetReachCommand(int reach)
    {
        super(reach);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetReach;
    }

    public int getReach()
    {
        return getArgumentAt(0, -1);
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetReach(this);
    }
}
