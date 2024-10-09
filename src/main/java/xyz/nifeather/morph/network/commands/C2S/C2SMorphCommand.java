package xyz.nifeather.morph.network.commands.C2S;

import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;

public class C2SMorphCommand extends AbstractC2SCommand<String>
{
    public C2SMorphCommand(@Nullable String identifier)
    {
        super(identifier == null ? "" : identifier);
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.Morph;
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onMorphCommand(this);
    }
}
