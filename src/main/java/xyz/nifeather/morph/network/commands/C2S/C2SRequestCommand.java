package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

import java.util.Arrays;

public class C2SRequestCommand extends AbstractC2SCommand<String>
{
    @Environment(EnvironmentType.SERVER)
    public C2SRequestCommand(String rawArg)
    {
        super(rawArg.split(" "));
    }

    public C2SRequestCommand(Decision decision, String targetRequestName)
    {
        super(new String[]{decision.name().toLowerCase(), targetRequestName});
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
        this.decision = Arrays.stream(Decision.values()).filter(v -> v.name().equalsIgnoreCase(getArgumentAt(0, "unknown")))
                .findFirst().orElse(Decision.UNKNOWN);

        this.targetRequestName = getArgumentAt(1, "unknown");

        listener.onRequestCommand(this);
    }

    public enum Decision
    {
        ACCEPT,
        DENY,
        UNKNOWN;
    }
}
