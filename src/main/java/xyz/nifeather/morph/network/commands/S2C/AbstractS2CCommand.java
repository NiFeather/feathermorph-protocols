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
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractS2CCommand<T>
{
    public abstract String getBaseName();

    @Environment(EnvironmentType.CLIENT)
    public abstract void onCommand(BasicServerHandler<?> handler);

    //region Utilities

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    protected static Gson gson()
    {
        return gson;
    }

    public abstract Map<String, String> generateArgumentMap();
    //endregion Utilities
}
