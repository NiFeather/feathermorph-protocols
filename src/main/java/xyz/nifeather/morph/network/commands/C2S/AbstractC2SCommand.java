package xyz.nifeather.morph.network.commands.C2S;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Environment(EnvironmentType.SERVER)
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

    /**
     * @deprecated Use Gson instead.
     * @return
     */
    @Deprecated(forRemoval = true)
    public String buildCommand()
    {
        return (getBaseName() + " " + serializeArguments()).trim();
    }

    //region Utilities

    protected String serializeArgumentSingle(T arg)
    {
        return arg.toString();
    }

    public List<String> serializeArgumentList()
    {
        return arguments.stream()
                .map(this::serializeArgumentSingle)
                .collect(Collectors.toList());
    }

    @Deprecated(forRemoval = true)
    public String serializeArguments()
    {
        if (arguments.isEmpty())
            return "";

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
