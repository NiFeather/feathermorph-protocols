package xiamomc.morph.network;

public class Constants
{
    public static final int PROTOCOL_VERSION = 5;
    public static Boolean IsServer = null;

    public static void initialize(boolean isServer)
    {
        if (IsServer != null) throw new RuntimeException("");

        IsServer = isServer;
    }
}