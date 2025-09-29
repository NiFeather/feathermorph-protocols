package xyz.nifeather.morph.network.commands.S2C.set;

import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.ProtocolEquipmentSlot;

@Deprecated(forRemoval = true)
public abstract class S2CSetFakeEquipCommand<TItemStack> extends AbstractS2CSetCommand<TItemStack>
{
    protected S2CSetFakeEquipCommand(TItemStack item, ProtocolEquipmentSlot slot)
    {
        this.slot = slot;
        this.item = item;
    }

    private final TItemStack item;

    private final ProtocolEquipmentSlot slot;

    public ProtocolEquipmentSlot getSlot()
    {
        return slot;
    }

    public TItemStack getItemStack()
    {
        return item;
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetFakeEquip;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetFakeEquipCommand(this);
    }
}
