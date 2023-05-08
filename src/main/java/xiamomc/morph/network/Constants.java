package xiamomc.morph.network;

public class Constants
{
    public static final int PROTOCOL_VERSION = 6;
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
        DENY_EARLY_COMMANDS(2),
        SWAP_AND_SKILL(3),
        INDEPENDENT_PROTOCOL(5),
        BOUNDINGBOX_AND_REACH(6);

        public final int protocolVersion;

        ApiLevel(int protocolVersion)
        {
            this.protocolVersion = protocolVersion;
        }
    }
}