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

public class S2CQueryCommand extends AbstractS2CCommand<String>
{
    public static S2CQueryCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, S2CQueryCommand.class, 2);

        var type = QueryType.tryValueOf(arguments.remove(0));
        return new S2CQueryCommand(type, arguments);
    }

    public S2CQueryCommand(QueryType queryType, List<String> diff)
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

