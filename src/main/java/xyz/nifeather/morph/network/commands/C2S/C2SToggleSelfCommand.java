package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.BasicClientHandler;
import xyz.nifeather.morph.network.annotations.Environment;
import xyz.nifeather.morph.network.annotations.EnvironmentType;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Map;

public class C2SToggleSelfCommand extends AbstractC2SCommand<C2SToggleSelfCommand.SelfViewMode>
{
    private final SelfViewMode selfViewMode;

    public C2SToggleSelfCommand(SelfViewMode val)
    {
        this.selfViewMode = val;
    }

    public SelfViewMode getSelfViewMode()
    {
        return selfViewMode;
    }

    public static C2SToggleSelfCommand fromArguments(Map<String, String> arguments) throws RuntimeException
    {
        return new C2SToggleSelfCommand(SelfViewMode.fromNetworkname(Asserts.getStringOrThrow(arguments, "mode")));
    }

    @Override
    public Map<String, String> generateArgumentMap()
    {
        return Map.of(
                "mode", selfViewMode.networkName
        );
    }

    @Override
    public String getBaseName()
    {
        return C2SCommandNames.ToggleSelf;
    }

    @Environment(EnvironmentType.SERVER)
    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onToggleSelfCommand(this);
    }

    public enum SelfViewMode
    {
        /**
         * 启用自身可见
         */
        ON("true"),

        /**
         * 禁用自身可见
         */
        OFF("false"),

        /**
         * 声明自身可见将被客户端处理
         */
        CLIENT_ON("client true"),

        /**
         * 声明自身可见不再被客户端处理
         */
        CLIENT_OFF("client false");

        private final String networkName;

        public static SelfViewMode fromBoolean(boolean value)
        {
            return value ? ON : OFF;
        }
        public static SelfViewMode fromNetworkname(String str) throws RuntimeException
        {
            if (str.equalsIgnoreCase("true")) return ON;
            else if (str.equalsIgnoreCase("false")) return OFF;
            else if (str.equalsIgnoreCase("client true")) return CLIENT_ON;
            else if (str.equalsIgnoreCase("client false")) return CLIENT_OFF;

            throw new RuntimeException("No matched SelfViewMode for input '%s'".formatted(str));
        }

        SelfViewMode(String networkName)
        {
            this.networkName = networkName;
        }

        @Override
        public String toString()
        {
            return networkName;
        }
    }
}
