package xyz.nifeather.morph.network.commands.S2C.query;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.List;
import java.util.Map;

public class S2CQueryCommand extends AbstractS2CCommand<String>
{
    public static S2CQueryCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var type = QueryType.tryValueOf(Asserts.getStringOrThrow(arguments, "type"));
        return new S2CQueryCommand(type, Asserts.getStringListOrThrow(arguments, "diff"));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "type", this.queryType.name(),
                "diff", gson().toJson(this.diff)
        );
    }

    private final QueryType queryType;
    private final List<String> diff;

    public S2CQueryCommand(QueryType queryType, List<String> diff)
    {
        this.diff = diff;
        this.queryType = queryType;
    }

    public QueryType queryType()
    {
        return this.queryType;
    }

    public List<String> getDiff()
    {
        return diff;
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.Query;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onQueryCommand(this);
    }
}

