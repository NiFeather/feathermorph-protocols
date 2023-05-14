package xiamomc.morph.network;

public class Constants
{
    public static final int PROTOCOL_VERSION = ApiLevel.REQUEST_HANDLING.protocolVersion;
    private static Boolean IsServer = null;

    public static boolean isServer()
    {
        return IsServer != null && IsServer;
    }

    public static void initialize(boolean isServer)
    {
        if (IsServer != null)
            throw new RuntimeException("Already initialized once!");

        IsServer = isServer;
    }

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
        REQUEST_HANDLING(7)
        ;

        public final int protocolVersion;

        ApiLevel(int protocolVersion)
        {
            this.protocolVersion = protocolVersion;
        }
    }
}