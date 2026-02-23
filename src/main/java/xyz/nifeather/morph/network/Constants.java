package xyz.nifeather.morph.network;

public class Constants
{
    public static final int PROTOCOL_VERSION = ApiLevel.SADDLE_AND_BODY_EQUIPMENT_SLOT.protocolVersion;

    public enum ApiLevel
    {
        LEGACY(1),

        /**
         * Deny commands before initialization is done (Both server and client side)
         */
        DENY_EARLY_COMMANDS(2),

        /**
         * S2CSwapCommand and C2SSKillCommand
         */
        SWAP_AND_SKILL(3),

        @Deprecated(forRemoval = true)
        PREINDEPENDENT_PROTOCOL(4),

        /**
         * Protocol becomes a independent libarary
         */
        INDEPENDENT_PROTOCOL(5),

        /**
         * S2CSetBoundingBox and S2CSetReach command
         */
        BOUNDINGBOX_AND_REACH(6),

        /**
         * Server <-> Client Exchange request handling
         */
        REQUEST_HANDLING(7),

        /**
         * S2CSetSpiderCommand
         *
         * @deprecated Triggers anti-cheat and doesn't consider latency
         */
        @Deprecated
        SPIDER(8),

        /**
         * Revealing State (S2CSetRevealingCommand)
         */
        REVEALING(9),

        /**
         * Admin revealing (Display player name above their disguise)
         */
        ADMIN_REVEALING(10),

        /**
         * Client renderer protocol V1
         */
        CLIENT_RENDERER_V1(11),

        /**
         * Animation command
         */
        ANIMATION(12),

        /**
         * We now use (Friendly / Packet)ByteBuf methods to serialize commands into bytes.
         */
        WE_NOW_USE_PACKETBUF(13),

        /**
         * We now use Gson to send commands!
         */
        WE_NOW_USE_JSON(14),

        /**
         * The usage of NBT is now deprecated, means that servers using API 15 will NOT compatible with clients implementing older APIs.
         */
        NETWORK_DISGUISE_PROPERTIES(15),

        /**
         * Removed equipment and skin commands as they are now using disguise property
         */
        EQUIPMENT_AND_SKIN_ARE_NOW_PROPERTY(16),

        /**
         * Property inputs are now allowed in morph c2s command
         */
        PROPERTY_INPUT_IN_MORPH_COMMAND(17),

        /**
         * Saddle and Body slot has been added to {@link ProtocolEquipmentSlot}
         */
        SADDLE_AND_BODY_EQUIPMENT_SLOT(18)
        ;

        public final int protocolVersion;

        ApiLevel(int protocolVersion)
        {
            this.protocolVersion = protocolVersion;
        }
    }
}