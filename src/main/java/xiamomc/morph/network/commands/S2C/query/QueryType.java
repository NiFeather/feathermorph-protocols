package xiamomc.morph.network.commands.S2C.query;

public enum QueryType
{
    UNKNOWN,
    ADD,
    REMOVE,
    SET;

    public static QueryType tryValueOf(String str)
    {
        try
        {
            return QueryType.valueOf(str);
        }
        catch (Throwable t)
        {
            return UNKNOWN;
        }
    }
}
