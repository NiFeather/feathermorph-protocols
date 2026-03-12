package xyz.nifeather.morph.network.commands.S2C;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CDiscardTemporaryPropertiesCommand extends S2CDiscardPropertiesCommand
{
    public S2CDiscardTemporaryPropertiesCommand(List<String> properties)
    {
        super(properties);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.DiscardTemporaryProperties;
    }

    @Override
    public void onCommand(BasicServerHandler<?> basicServerHandler)
    {
        basicServerHandler.onDiscardTemporaryPropertiesCommand(this);
    }

    public static S2CDiscardTemporaryPropertiesCommand fromArguments(Map<String, String> arguments)
            throws RuntimeException
    {
        var propertyList = Asserts.getStringOrThrow(arguments, "properties");
        var list = gson().fromJson(propertyList, List.class).stream().map(Object::toString).toList();

        return new S2CDiscardTemporaryPropertiesCommand(list);
    }
}
