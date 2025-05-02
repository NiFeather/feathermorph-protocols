package xyz.nifeather.morph.network.commands.S2C.set;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class S2CSetAvailableAnimationsCommand extends AbstractS2CSetCommand<String>
{
    private final List<String> animations;

    public S2CSetAvailableAnimationsCommand(List<String> ids)
    {
        this.animations = ids;
    }

    public static S2CSetAvailableAnimationsCommand fromArguments(Map<String, String> arguments)
    {
        var listString = Asserts.getStringOrThrow(arguments, "anim_list");
        var stringList = gson().fromJson(listString, List.class)
                .stream()
                .map(Object::toString)
                .toList();

        return new S2CSetAvailableAnimationsCommand(stringList);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetAvailableAnimations;
    }

    public List<String> getAvailableAnimations()
    {
        return new ObjectArrayList<>(this.animations);
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onValidAnimationsCommand(this);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        var listString = gson().toJson(this.animations);
        return Map.of("anim_list", listString);
    }
}
