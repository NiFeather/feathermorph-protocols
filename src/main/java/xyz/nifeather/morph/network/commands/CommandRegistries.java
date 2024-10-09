package xyz.nifeather.morph.network.commands;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.commands.C2S.AbstractC2SCommand;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;

import java.util.function.Function;

public class CommandRegistries
{
    private final Object2ObjectArrayMap<String, Function<String, AbstractC2SCommand<?>>> c2sCmds = new Object2ObjectArrayMap<>();
    private final Object2ObjectArrayMap<String, Function<String, AbstractS2CCommand<?>>> s2cCmds = new Object2ObjectArrayMap<>();

    /**
     *
     * @param name
     * @param function args -> function
     * @return
     */
    public CommandRegistries registerC2S(String name, Function<String, AbstractC2SCommand<?>> function)
    {
        c2sCmds.put(name, function);

        return this;
    }

    public CommandRegistries registerS2C(String name, Function<String, AbstractS2CCommand<?>> function)
    {
        s2cCmds.put(name, function);

        return this;
    }

    @Nullable
    public AbstractS2CCommand<?> createS2CCommand(String baseName, String args)
    {
        var func = s2cCmds.getOrDefault(baseName, null);
        return func == null ? null : func.apply(args);
    }

    @Nullable
    public AbstractC2SCommand<?> createC2SCommand(String baseName, String args)
    {
        var func = c2sCmds.getOrDefault(baseName, null);
        return func == null ? null : func.apply(args);
    }
}
