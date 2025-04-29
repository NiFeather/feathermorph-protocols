package xyz.nifeather.morph.network.commands.S2C.query;

public enum QueryType
{
    UNKNOWN,
    ADD,
    REMOVE,
    SET;

    public static QueryType tryValueOf(String str) throws RuntimeException
    {
        try
        {
            return QueryType.valueOf(str.toUpperCase());
        }
        catch (Throwable t)
        {
            throw new RuntimeException("Unknown QueryType for input string '%s'".formatted(str));
        }
    }
}
