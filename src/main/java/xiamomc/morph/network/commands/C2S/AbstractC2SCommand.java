package xiamomc.morph.network.commands.C2S;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xiamomc.morph.network.BasicClientHandler;
import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.Constants;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractC2SCommand<T>
{
    public abstract String getBaseName();

    public AbstractC2SCommand()
    {
        arguments = new ArrayList<>();
    }

    public AbstractC2SCommand(@Nullable T argument)
    {
        this.arguments = toList(argument);
    }

    public AbstractC2SCommand(@Nullable T[] arguments)
    {
        this.arguments = toList(arguments);
    }

    @NotNull
    protected List<T> arguments;

    protected List<T> toList(T... elements)
    {
        if (elements == null)
            return new ArrayList<>();

        return Arrays.stream(elements).toList();
    }

    public abstract void onCommand(BasicClientHandler<?> listener);

    private Object owner;
    public <TPlayer> void setOwner(TPlayer player)
    {
        this.owner = player;
    }

    public <TPlayer> TPlayer getOwner()
    {
        return (TPlayer) owner;
    }

    public String buildCommand()
    {
        return (getBaseName() + " " + serializeArguments()).trim();
    }

    //region Utilities

    public String serializeArguments()
    {
        if (arguments.size() == 0) return "";

        var builder = new StringBuilder();
        for (T argument : arguments)
            builder.append(argument).append(" ");

        return builder.toString();
    }

    @Nullable
    public T getArgumentAt(int index)
    {
        return index >= arguments.size() ? null : arguments.get(index);
    }

    @NotNull
    public T getArgumentAt(int index, @NotNull T defaultValue)
    {
        var val = this.getArgumentAt(index);

        return val == null ? defaultValue : val;
    }

    //endregion Utilities
}
