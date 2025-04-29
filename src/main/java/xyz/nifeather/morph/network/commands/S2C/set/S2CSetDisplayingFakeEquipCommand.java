package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.commands.S2C.S2CRequestCommand;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CSetDisplayingFakeEquipCommand extends AbstractS2CSetCommand<Boolean>
{
    public final boolean displaying;

    public S2CSetDisplayingFakeEquipCommand(boolean val)
    {
        this.displaying = val;
    }

    public static S2CSetDisplayingFakeEquipCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new S2CSetDisplayingFakeEquipCommand(Boolean.parseBoolean(Asserts.getStringOrThrow(arguments, "val")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("val", displaying + "");
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetDisplayingFakeEquip;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetDisplayingFakeEquipCommand(this);
    }
}
