package xyz.nifeather.morph.network.commands.S2C.query;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.List;

public class S2CQueryCommand extends AbstractS2CCommand<String>
{
    @Nullable
    public static S2CQueryCommand from(String rawArg)
    {
        var spilt = rawArg.split(" ", 2);
        if (spilt.length < 1) return null;

        var type = QueryType.tryValueOf(spilt[0].toUpperCase());
        return new S2CQueryCommand(type, spilt.length == 2 ? spilt[1].split(" ") : new String[]{});
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
        return S2CCommandNames.Query;
    }

    @Override
    public List<String> serializeArgumentList()
    {
        var list = new ObjectArrayList<String>();

        list.add(queryType.name().toLowerCase());
        list.addAll(super.serializeArgumentList());

        return list;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public void onCommand(BasicServerHandler<?> handler)
    {
        handler.onQueryCommand(this);
    }
}

