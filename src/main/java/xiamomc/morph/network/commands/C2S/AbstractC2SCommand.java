package xiamomc.morph.network.commands.C2S;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xiamomc.morph.network.BasicServerHandler;
import xiamomc.morph.network.Constants;
import xiamomc.morph.network.annotations.Environment;
import xiamomc.morph.network.annotations.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractC2SCommand<TPlatformPlayer, T>
{
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

    @SafeVarargs
    private List<T> toList(T... elements)
    {
        if (elements == null)
            return new ArrayList<>();

        return Arrays.stream(elements).toList();
    }

    public abstract String getBaseName();

    /**
     * @param rawArguments 由客户端发来的参数
     */
    public void onCommand(TPlatformPlayer player, String rawArguments) { }

    public String buildCommand()
    {
        return getBaseName();
    }

    //region Utilities

    protected T getArgumentAt(List<T> arguments, int index, @NotNull T defaultValue)
    {
        var val = this.getArgumentAt(arguments, index);

        return val == null ? defaultValue : val;
    }

    protected T getArgumentAt(List<T> arguments, int index)
    {
        return index >= arguments.size() ? null : arguments.get(index);
    }

    @Nullable
    protected T getArgumentAt(T[] arguments, int index)
    {
        return index >= arguments.length ? null : arguments[index];
    }

    @NotNull
    protected T getArgumentAt(T[] arguments, int index, @NotNull T defaultValue)
    {
        var val = this.getArgumentAt(arguments, index);

        return val == null ? defaultValue : val;
    }

    //endregion Utilities
}
