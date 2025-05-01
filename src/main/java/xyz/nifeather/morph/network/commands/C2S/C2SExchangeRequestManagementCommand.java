package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Arrays;
import java.util.Map;

public class C2SExchangeRequestManagementCommand extends AbstractC2SCommand<String>
{
    public C2SExchangeRequestManagementCommand(Decision decision, String targetRequestName)
    {
        this.decision = decision;
        this.targetRequestName = targetRequestName;
    }

    public static C2SExchangeRequestManagementCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        var decisionName = Asserts.getStringOrThrow(arguments, "decision");
        var targetPlayerName = Asserts.getStringOrThrow(arguments, "request");

        var decision = Arrays.stream(Decision.values()).filter(v -> v.name().equalsIgnoreCase(decisionName))
                .findFirst().orElseThrow(() -> new RuntimeException("No matched Decision for input '%s'".formatted(decisionName)));

        return new C2SExchangeRequestManagementCommand(decision, targetPlayerName);
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "decision", decision.name(),
                "request", targetRequestName
        );
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.ExchangeRequestManagement;
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
