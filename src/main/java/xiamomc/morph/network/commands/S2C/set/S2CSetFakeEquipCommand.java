package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.S2CCommandNames;

public abstract class S2CSetFakeEquipCommand<TItemStack> extends AbstractS2CSetCommand<TItemStack>
{
    public S2CSetFakeEquipCommand(TItemStack item, ProtocolEquipmentSlot slot)
    {
        super(item);
        this.slot = slot;
    }

    private final ProtocolEquipmentSlot slot;

    public ProtocolEquipmentSlot getSlot()
    {
        return slot;
    }

    public TItemStack getItemStack()
    {
        return getArgumentAt(0);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.SetFakeEquip;
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetFakeEquipCommand(this);
    }

    public enum ProtocolEquipmentSlot
    {
        MAINHAND,
        OFF_HAND,

        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS;

        @Override
        public String toString()
        {
            return this.name().toLowerCase();
        }
    }
}
