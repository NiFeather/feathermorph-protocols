package xiamomc.morph.network.commands.C2S;

import xiamomc.morph.network.BasicClientHandler;

public class C2SUnmorphCommand extends AbstractC2SCommand<String>
{
    @Override
    public String getBaseName()
    {
        return C2SCommandNames.Unmorph;
    }

    @Override
    public void onCommand(BasicClientHandler<?> listener)
    {
        listener.onUnmorphCommand(this);
    }
}
