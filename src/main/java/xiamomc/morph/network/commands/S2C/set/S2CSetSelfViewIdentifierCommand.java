package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.EnvironmentType;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

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

    @Override
    public String buildCommand()
    {
        return super.buildCommand() + " " + this.getArgumentAt(0, "");
    }
}
