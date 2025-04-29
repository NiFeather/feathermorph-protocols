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
import java.util.Objects;

public class C2SSetSingleOptionCommand extends AbstractC2SCommand<C2SSetSingleOptionCommand.ClientOptionEnum>
{
    public C2SSetSingleOptionCommand(@NotNull C2SSetSingleOptionCommand.ClientOptionEnum option)
    {
        super(option);
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onOptionCommand(this);
    }

    private String value;

    public C2SSetSingleOptionCommand setValue(String value)
    {
        this.value = value;

        return this;
    }

    public C2SSetSingleOptionCommand setValue(Boolean value)
    {
        return this.setValue(value ? "true" : "false");
    }

    public ClientOptionEnum getOption()
    {
        return getArgumentAt(0);
    }

    public String getValue()
    {
        return value;
    }

    public static C2SSetSingleOptionCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, C2SSetSingleOptionCommand.class, 2);

        var optionName = arguments.getFirst();
        var option = Arrays.stream(ClientOptionEnum.values())
                .filter(v -> v.networkName.equalsIgnoreCase(optionName))
                .findFirst().orElseThrow(() -> new RuntimeException("No matched ClientOptionEnum for input '%s'".formatted(optionName)));

        var value = arguments.get(1);
        return new C2SSetSingleOptionCommand(option).setValue(value);
    }

    @Override
    public List<String> serializeArgumentList()
    {
        var list = new ObjectArrayList<String>();

        list.add(this.getOption().toString());
        list.add(this.value);

        return list;
    }

    @Nullable
    public static C2SSetSingleOptionCommand fromString(String rawArgs)
    {
        var spilt = rawArgs.split(" ", 2);

        if (spilt.length < 2) return null;

        var option = Arrays.stream(ClientOptionEnum.values())
                .filter(v -> v.networkName.equalsIgnoreCase(spilt[0]))
                .findFirst().orElse(null);

        if (option == null) return null;

        var value = spilt[1];

        var instance = new C2SSetSingleOptionCommand(option);
        instance.setValue(value);

        return instance;
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.SetSingleOption;
    }

    @Override
    protected String serializeArgumentSingle(ClientOptionEnum arg)
    {
        return super.serializeArgumentSingle(arg);
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
