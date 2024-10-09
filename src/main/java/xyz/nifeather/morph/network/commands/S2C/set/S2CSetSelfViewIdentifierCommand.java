package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

public class S2CSetSelfViewIdentifierCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetSelfViewIdentifierCommand(String identifier)
    {
        super(identifier);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSelfViewIdentifier;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSelfViewIdentifierCommand(this);
    }
}
