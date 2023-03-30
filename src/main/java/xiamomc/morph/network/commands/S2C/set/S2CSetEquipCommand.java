package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.BasicServerHandler;

public abstract class S2CSetEquipCommand<TItemStack> extends AbstractS2CSetCommand<TItemStack>
{
    public S2CSetEquipCommand(TItemStack item, ProtocolEquipmentSlot slot)
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
        return "equip";
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onSetEquipCommand(this);
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
