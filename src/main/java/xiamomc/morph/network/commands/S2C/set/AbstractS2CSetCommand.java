package xiamomc.morph.network.commands.S2C.set;

import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;

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
    public String buildCommand()
    {
        return "set " + getBaseName();
    }
}
