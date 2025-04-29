package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Arrays;
import java.util.List;

public class C2SRequestCommand extends AbstractC2SCommand<String>
{
    public C2SRequestCommand(Decision decision, String targetRequestName)
    {
        super(new String[]{decision.name().toLowerCase(), targetRequestName});
    }

    public static C2SRequestCommand fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, C2SRequestCommand.class, 2);

        var decisionName = arguments.getFirst();
        var targetPlayerName = arguments.get(1);

        var decision = Arrays.stream(Decision.values()).filter(v -> v.name().equalsIgnoreCase(decisionName))
                .findFirst().orElseThrow(() -> new RuntimeException("No matched Decision for input '%s'".formatted(decisionName)));

        return new C2SRequestCommand(decision, targetPlayerName);
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.Request;
    }

    @Environment(EnvironmentType.SERVER)
    public Decision decision;

    @Environment(EnvironmentType.SERVER)
    public String targetRequestName;

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onRequestCommand(this);
    }

    public enum Decision
    {
        ACCEPT,
        DENY,
        UNKNOWN;
    }
}
