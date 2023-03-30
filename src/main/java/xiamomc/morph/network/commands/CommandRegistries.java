package xiamomc.morph.network.commands;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import org.jetbrains.annotations.Nullable;
import xiamomc.morph.network.commands.C2S.AbstractC2SCommand;
import xiamomc.morph.network.commands.S2C.AbstractS2CCommand;

public class CommandRegistries<TPlatformPlayer>
{
    private final Object2ObjectArrayMap<String, AbstractC2SCommand<TPlatformPlayer, ?>> c2sCmds = new Object2ObjectArrayMap<>();
    private final Object2ObjectArrayMap<String, AbstractS2CCommand<?>> s2cCmds = new Object2ObjectArrayMap<>();

    public void register(AbstractC2SCommand<TPlatformPlayer, ?> c2sCmd)
    {
        c2sCmds.put(c2sCmd.getBaseName(), c2sCmd);
    }

    public void register(AbstractC2SCommand<TPlatformPlayer, ?>... c2sCmds)
    {
        for (AbstractC2SCommand<TPlatformPlayer, ?> cmd : c2sCmds)
        {
            this.register(cmd);
        }
    }

    public void register(AbstractS2CCommand<?>... s2cCmds)
    {
        for (AbstractS2CCommand<?> s2cCmd : s2cCmds)
        {
            this.register(s2cCmd);
        }
    }

    public void register(AbstractS2CCommand<?> s2cCmd)
    {
        s2cCmds.put(s2cCmd.getBaseName(), s2cCmd);
    }

    @Nullable
    public AbstractS2CCommand<?> getS2CCommand(String baseName)
    {
        return s2cCmds.getOrDefault(baseName, null);
    }

    @Nullable
    public AbstractC2SCommand<TPlatformPlayer, ?> getC2SCommand(String baseName)
    {
        return c2sCmds.getOrDefault(baseName, null);
    }
}
