package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.List;

public class S2CSwapCommand extends AbstractS2CCommand<String>
{
    @Override
    public String getBaseName() {
        return S2CCommandNames.SwapHands;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSwapCommand(this);
    }

    public static S2CSwapCommand fromArguments(List<String> arguments)
    {
        return new S2CSwapCommand();
    }
}
