package xyz.nifeather.morph.network.commands.C2S;

import xyz.nifeather.morph.network.commands.S2C.S2CCommandNames;

public class C2SCommandNames
{
    public static final String Initial = "initial";
    public static final String Morph = "morph";

    public static final String SetSingleOption = "option";

    @Deprecated(forRemoval = true)
    public static final String Option = SetSingleOption;

    public static final String Skill = "skill";
    public static final String ToggleSelf = "c2s_toggleself";
    public static final String Unmorph = "unmorph";

    public static final String Request = S2CCommandNames.Request;
    public static final String RequestAccept = S2CCommandNames.Request;
    public static final String RequestDeny = S2CCommandNames.Request;
}
