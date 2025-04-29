package xyz.nifeather.morph.network.commands.S2C;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.Constants;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractS2CCommand<T>
{
    protected AbstractS2CCommand()
    {
        arguments = new ArrayList<>();
    }

    protected AbstractS2CCommand(@Nullable T argument)
    {
        this.arguments = toList(argument);
    }

    protected AbstractS2CCommand(@Nullable T[] arguments)
    {
        this.arguments = toList(arguments);
    }

    protected AbstractS2CCommand(@Nullable List<T> arguments)
    {
        if (arguments != null)
            this.arguments = new ObjectArrayList<>(arguments);
        else
            this.arguments = List.of();
    }

    @NotNull
    @Unmodifiable
    protected List<T> arguments;

    @SafeVarargs
    private List<T> toList(T... elements)
    {
        if (elements == null)
            return new ArrayList<>();

        return Arrays.stream(elements).toList();
    }

    public abstract String getBaseName();

    @Environment(EnvironmentType.CLIENT)
    public abstract void onCommand(BasicServerHandler<?> handler);

    //region Utilities

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    protected static Gson gson()
    {
        return gson;
    }

    protected String serializeArgumentSingle(@Nullable T arg)
    {
        return arg == null ? "null" : arg.toString();
    }

    public List<String> serializeArgumentList()
    {
        return arguments.stream()
                .map(this::serializeArgumentSingle)
                .collect(Collectors.toList());
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
