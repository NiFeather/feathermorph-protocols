package xyz.nifeather.morph.network.commands.C2S;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class C2SSetSingleOptionCommand extends AbstractC2SCommand<C2SSetSingleOptionCommand.ClientOptionEnum>
{
    private final ClientOptionEnum optionEnum;
    private final String value;

    public C2SSetSingleOptionCommand(@NotNull C2SSetSingleOptionCommand.ClientOptionEnum option, boolean value)
    {
        this.optionEnum = option;
        this.value = Boolean.toString(value);
    }

    public C2SSetSingleOptionCommand(@NotNull C2SSetSingleOptionCommand.ClientOptionEnum option, String value)
    {
        this.optionEnum = option;
        this.value = value;
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onOptionCommand(this);
    }

    public ClientOptionEnum getOption()
    {
        return optionEnum;
    }

    public String getValue()
    {
        return value;
    }

    public static C2SSetSingleOptionCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var optionName = Asserts.getStringOrThrow(arguments, "option");
        var option = Arrays.stream(ClientOptionEnum.values())
                .filter(v -> v.networkName.equalsIgnoreCase(optionName))
                .findFirst().orElseThrow(() -> new RuntimeException("No matched ClientOptionEnum for input '%s'".formatted(optionName)));

        var value = Asserts.getStringOrThrow(arguments, "value");
        return new C2SSetSingleOptionCommand(option, value);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "option", optionEnum.networkName,
                "value", value
        );
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.SetSingleOption;
    }

    public enum ClientOptionEnum
    {
        CLIENTVIEW("clientview"),
        HUD("hud");

        private ClientOptionEnum(String optionNetworkName)
        {
            this.networkName = optionNetworkName;
        }

        public final String networkName;
    }
}
