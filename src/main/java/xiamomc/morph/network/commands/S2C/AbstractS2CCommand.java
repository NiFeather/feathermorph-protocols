package xiamomc.morph.network.commands.S2C;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xiamomc.morph.network.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractS2CCommand<T>
{
    public AbstractS2CCommand()
    {
        arguments = new ArrayList<>();
    }

    public AbstractS2CCommand(@Nullable T argument)
    {
        this.arguments = toList(argument);
    }

    public AbstractS2CCommand(@Nullable T[] arguments)
    {
        this.arguments = toList(arguments);
    }

    @NotNull
    protected List<T> arguments;

    @SafeVarargs
    private List<T> toList(T... elements)
    {
        if (elements == null)
            return new ArrayList<>();

        return Arrays.stream(elements).toList();
    }

    public abstract String getBaseName();

    /**
     * 带 {@link AbstractS2CCommand#getBaseName()} 的详细参数
     * @param arguments 由服务端发来的参数
     */
    public void onCommand(String arguments) { }

    public String buildCommand()
    {
        return (getBaseName() + " " + serializeArguments()).trim();
    }

    //region Utilities

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    protected Gson gson()
    {
        return gson;
    }

    protected String serializeArguments()
    {
        if (arguments.size() == 0) return "";

        var builder = new StringBuilder();
        for (T argument : arguments)
            builder.append(argument).append(" ");

        return builder.toString().trim();
    }

    @Nullable
    protected T getArgumentAt(int index)
    {
        return index >= arguments.size() ? null : arguments.get(index);
    }

    @NotNull
    protected T getArgumentAt(int index, @NotNull T defaultValue)
    {
        var val = this.getArgumentAt(index);

        return val == null ? defaultValue : val;
    }
    //endregion Utilities
}
