package xiamomc.morph.network.commands.C2S;

import xiamomc.morph.network.BasicClientHandler;

public class C2SToggleSelfCommand extends AbstractC2SCommand<C2SToggleSelfCommand.SelfViewMode>
{
    public C2SToggleSelfCommand(SelfViewMode val)
    {
        super(val);
    }

    public SelfViewMode getSelfViewMode()
    {
        return getArgumentAt(0);
    }


    @Override
    public String getBaseName()
    {
        return C2SCommandNames.ToggleSelf;
    }

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
        public static SelfViewMode fromString(String str)
        {
            if (str.equalsIgnoreCase("true")) return ON;
            else if (str.equalsIgnoreCase("false")) return OFF;
            else if (str.equalsIgnoreCase("client true")) return CLIENT_ON;
            else if (str.equalsIgnoreCase("client false")) return CLIENT_OFF;

            return OFF;
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
