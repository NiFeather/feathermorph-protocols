package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CSetModifyBoundingBoxCommand extends AbstractS2CSetCommand<Boolean>
{
    private final boolean doModify;

    public S2CSetModifyBoundingBoxCommand(boolean val)
    {
        this.doModify = val;
    }

    public boolean getModifyBoundingBox()
    {
        return doModify;
    }

    public static S2CSetModifyBoundingBoxCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetModifyBoundingBoxCommand(Boolean.parseBoolean(Asserts.getStringOrThrow(arguments, "val")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("val", doModify + "");
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetModifyBoundingBox;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetModifyBoundingBox(this);
    }
}
