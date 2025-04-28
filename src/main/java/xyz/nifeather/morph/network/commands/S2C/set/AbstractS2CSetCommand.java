package xyz.nifeather.morph.network.commands.S2C.set;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.List;

public abstract class AbstractS2CSetCommand<T> extends AbstractS2CCommand<T>
{
    public AbstractS2CSetCommand(T argument)
    {
        super(argument);
    }

    public AbstractS2CSetCommand(T... arguments)
    {
        super(arguments);
    }

    public List<T> getArguments()
    {
        return arguments;
    }

    @Override
    public List<String> buildCommand()
    {
        var list = new ObjectArrayList<String>();

        list.add(S2CCommandNames.BaseSet);
        list.addAll(super.buildCommand());

        return list;
    }
}
