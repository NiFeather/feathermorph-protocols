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
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractC2SCommand<T>
{
    public abstract String getBaseName();

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

    //region Utilities

    public abstract Map<String, String> generateArgumentMap();

    //endregion Utilities
}
