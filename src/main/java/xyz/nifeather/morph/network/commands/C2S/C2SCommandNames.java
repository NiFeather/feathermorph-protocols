package xyz.nifeather.morph.network.commands.C2S;

public class C2SCommandNames
{
    public static final String RequestInitial = "request_initial";
    public static final String Morph = "morph";

    public static final String SetSingleOption = "set_single_option";

    public static final String RequestAnimation = "request_animation";

    public static final String ActivateSkill = "skill";
    public static final String ToggleSelf = "set_selfview_mode";
    public static final String Unmorph = "unmorph";

    public static final String ExchangeRequestManagement = "manage_request";

    @Deprecated(forRemoval = true)
    public static final String Option = SetSingleOption;
}
