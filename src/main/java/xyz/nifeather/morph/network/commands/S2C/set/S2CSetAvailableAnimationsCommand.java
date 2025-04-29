package xyz.nifeather.morph.network.commands.S2C.set;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xyz.nifeather.morph.network.BasicServerHandler;

import java.util.List;

public class S2CSetAvailableAnimationsCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetAvailableAnimationsCommand(List<String> ids)
    {
        super(ids.toArray(new String[]{}));
    }

    public static S2CSetAvailableAnimationsCommand fromArguments(List<String> arguments)
    {
        return new S2CSetAvailableAnimationsCommand(arguments);
    }

    @Override
    public String getBaseName()
    {
        return "avail_anim";
    }

    public List<String> getAvailableAnimations()
    {
        return new ObjectArrayList<>(this.getArguments());
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onValidAnimationsCommand(this);
    }
}
