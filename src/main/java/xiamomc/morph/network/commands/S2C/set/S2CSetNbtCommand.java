package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.commands.S2C.S2CCommandNames;

@Deprecated
public abstract class S2CSetNbtCommand<TCompound> extends AbstractS2CSetCommand<TCompound>
{
    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetNbt;
    }
}

/*
import net.minecraft.nbt.CompoundTag;
import xiamomc.morph.network.server.commands.S2C.AbstractS2CSetCommand;
import xiamomc.morph.utilities.NbtUtils;

public class S2CSetNbtCommand extends AbstractS2CSetCommand<CompoundTag>
{
    public S2CSetNbtCommand(CompoundTag tag)
    {
        super(tag);
    }

    @Override
    public String getBaseName()
    {
        return "nbt";
    }

    @Override
    public String buildCommand()
    {
        var nbt = this.getArgumentAt(0, new CompoundTag());
        return super.buildCommand() + " " + NbtUtils.getCompoundString(nbt);
    }
}
*/