package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CSetSelfViewingStatusCommand extends AbstractS2CSetCommand<Boolean>
{
    private final boolean selfViewing;

    public boolean selfViewing()
    {
        return selfViewing;
    }

    public S2CSetSelfViewingStatusCommand(Boolean val)
    {
        this.selfViewing = val;
    }

    public static S2CSetSelfViewingStatusCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetSelfViewingStatusCommand(Boolean.parseBoolean(Asserts.getStringOrThrow(arguments, "val")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("val", selfViewing + "");
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetSelfViewing;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetSelfViewingCommand(this);
    }
}
