package xyz.nifeather.morph.network.utils;

public enum ProtocolEquipmentSlot
{
    MAINHAND,
    OFF_HAND,

    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS,

    BODY,
    SADDLE;

    @Override
    public String toString()
    {
        return this.name().toLowerCase();
    }
}
