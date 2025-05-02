package xyz.nifeather.morph.network.commands.S2C.set;

import org.jetbrains.annotations.NotNull;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class S2CSetAnimationDisplayNameCommand extends AbstractS2CSetCommand<String>
{
    @NotNull
    private final String translateId;

    public S2CSetAnimationDisplayNameCommand(@NotNull String translateId)
    {
        this.translateId = translateId;
    }

    public static S2CSetAnimationDisplayNameCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var id = Asserts.getStringOrThrow(arguments, "translate");

        return new S2CSetAnimationDisplayNameCommand(id);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetAnimationDisplayName;
    }

    public String getDisplayIdentifier()
    {
        return translateId;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetAnimationDisplayCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of("translate", translateId);
    }
}
