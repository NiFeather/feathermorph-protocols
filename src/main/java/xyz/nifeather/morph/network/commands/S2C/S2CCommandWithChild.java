package xyz.nifeather.morph.network.commands.S2C;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicServerHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.set.AbstractS2CSetCommand;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public abstract class S2CCommandWithChild<T> extends AbstractS2CCommand<T>
{
    public S2CCommandWithChild(T... arguments)
    {
        super(arguments);
    }

    private final Map<String, Function<String, AbstractS2CSetCommand<?>>> nameToCmdMap = new ConcurrentHashMap<>();

    protected S2CCommandWithChild<T> register(String baseName, Function<String, AbstractS2CSetCommand<?>> func)
    {
        nameToCmdMap.put(baseName, func);

        return this;
    }

    @Environment(EnvironmentType.CLIENT)
    @Override
    public final void onCommand(BasicServerHandler<?> handler)
    {
        var rawArguments = serializeArgumentList();

        if (rawArguments.isEmpty()) return;

        var subBaseName = arguments.getFirst(); // assume the first is String...
        var subCmd = nameToCmdMap.getOrDefault(subBaseName, null)
                .apply(arguments.size() >= 2 ? this.serializeArgumentSingle(arguments.get(1)) : "");

        if (subCmd != null)
        {
            subCmd.onCommand(handler);
            return;
        }

        onCommandUnknown(rawArguments);
    }

    @Nullable
    public AbstractS2CSetCommand<?> getCommand(String args)
    {
        var str = args.split(" ", 2);

        if (str.length < 1) return null;
        var baseName = str[0];

        var func = nameToCmdMap.getOrDefault(baseName, null);
        return func == null ? null : func.apply(str.length == 2 ? str[1] : "");
    }

    protected void onCommandUnknown(List<String> arguments)
    {
    }
}
