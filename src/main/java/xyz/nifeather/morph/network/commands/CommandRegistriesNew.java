package xyz.nifeather.morph.network.commands;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.commands.C2S.AbstractC2SCommand;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class CommandRegistriesNew
{
    private final Object2ObjectArrayMap<String, Function<List<String>, AbstractC2SCommand<?>>> c2sCmds = new Object2ObjectArrayMap<>();
    private final Object2ObjectArrayMap<String, Function<List<String>, AbstractS2CCommand<?>>> s2cCmds = new Object2ObjectArrayMap<>();

    /**
     *
     * @param name
     * @param function args -> function
     * @return
     */
    public CommandRegistriesNew registerC2S(String name, Function<List<String>, AbstractC2SCommand<?>> function)
    {
        c2sCmds.put(name, function);

        return this;
    }

    public CommandRegistriesNew registerS2C(String name, Function<List<String>, AbstractS2CCommand<?>> function)
    {
        s2cCmds.put(name, function);

        return this;
    }

    @NotNull
    public AbstractS2CCommand<?> createS2CCommand(String baseName, List<String> args) throws RuntimeException
    {
        var func = s2cCmds.getOrDefault(baseName, null);
        return Objects.requireNonNull(func, "No Func found for command name '%s'".formatted(baseName)).apply(args);
    }

    @NotNull
    public AbstractC2SCommand<?> createC2SCommand(String baseName, List<String> args) throws RuntimeException
    {
        var func = c2sCmds.getOrDefault(baseName, null);
        return Objects.requireNonNull(func, "No Func found for command name '%s'".formatted(baseName)).apply(args);
    }
}
