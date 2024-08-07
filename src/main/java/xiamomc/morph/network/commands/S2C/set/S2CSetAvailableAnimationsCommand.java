package xiamomc.morph.network.commands.S2C.set;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xiamomc.morph.network.BasicServerHandler;

import java.util.List;

public class S2CSetAvailableAnimationsCommand extends AbstractS2CSetCommand<String>
{
    public S2CSetAvailableAnimationsCommand()
    {
    }

    public S2CSetAvailableAnimationsCommand(List<String> ids)
    {
        super(ids.toArray(new String[]{}));
    }

    public S2CSetAvailableAnimationsCommand(String... ids)
    {
        super(ids);
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

    @Override
    public String buildCommand()
    {
        return (super.buildCommand() + " " + this.serializeArguments()).trim();
    }

    public static S2CSetAvailableAnimationsCommand fromString(String arg)
    {
        return new S2CSetAvailableAnimationsCommand(arg.split(" "));
    }
}
