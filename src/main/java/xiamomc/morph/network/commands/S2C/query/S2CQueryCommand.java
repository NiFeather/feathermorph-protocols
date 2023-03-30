package xiamomc.morph.network.commands.S2C.query;

import org.jetbrains.annotations.Nullable;
import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;

import java.util.List;

public class S2CQueryCommand extends AbstractS2CCommand<String>
{
    @Nullable
    public static S2CQueryCommand from(String rawArg)
    {
        var spilt = rawArg.split(" ", 2);
        if (spilt.length < 2) return null;

        var type = QueryType.tryValueOf(spilt[0].toUpperCase());
        return new S2CQueryCommand(type, spilt[1].split(" "));
    }

    public S2CQueryCommand(QueryType queryType, String... diff)
    {
        super(diff);

        this.queryType = queryType;
    }

    private final QueryType queryType;

    public QueryType queryType()
    {
        return this.queryType;
    }

    public List<String> getDiff()
    {
        return arguments;
    }

    @Override
    public String getBaseName()
    {
        return "query";
    }

    @Override
    public String buildCommand()
    {
        return this.getBaseName() + " " + queryType.name().toLowerCase() + " " + serializeArguments();
    }

    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onQueryCommand(this);
    }
}

