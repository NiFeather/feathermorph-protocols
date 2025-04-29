package xyz.nifeather.morph.network.utils;

import java.util.List;

public class Asserts
{
    public static void assertArgumentCountAtLeast(List<?> list, Class<?> cmdClazz, int count)
    {
        if (list.size() < count)
        {
            throw new RuntimeException("At least %s argument(s) is required for %s, but got %s"
                    .formatted(count, cmdClazz.getSimpleName(), list.size()));
        }
    }
}
