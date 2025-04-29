package xyz.nifeather.morph.network.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Asserts
{
    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @NotNull
    public static String getStringOrThrow(Map<String, String> arguments, String targetElement) throws RuntimeException
    {
        var val = arguments.getOrDefault(targetElement, null);
        return Objects.requireNonNull(val, "No value found for required element '%s'".formatted(targetElement));
    }

    public static List<String> getStringListOrThrow(Map<String, String> arguments, String targetElement) throws RuntimeException
    {
        var listString = getStringOrThrow(arguments, targetElement);

        List<String> rawList = gson.fromJson(listString, List.class)
                .stream().map(Object::toString)
                .toList();

        return rawList;
    }
}
