package xyz.nifeather.morph.network.commands.S2C;

public class S2CCommandNames
{
    public static final String SetCurrent = "set_current";
    public static final String ReAuth = "reauth";
    public static final String UnAuth = "unauth";
    public static final String SwapHands = "action_swap_hand";
    public static final String Query = "query";

    public static final String UpdateRequestStatus = "update_request_status";

    public static final String SetAggressive = "set_aggressive";
    public static final String SetFakeEquip = "set_fake_equip";
    public static final String SetDisplayingFakeEquip = "set_displaying_fake_equip";
    public static final String SetSkinProfile = "set_skin_profile";
    public static final String SetSelfViewIdentifier = "set_selfview_id";
    public static final String SetSkillCooldown = "set_skill_cooldown";
    public static final String SetSNbt = "set_nbt";
    public static final String SetSneaking = "set_sneaking";
    public static final String SetSelfViewing = "set_clientview_enabled";
    public static final String SetModifyBoundingBox = "set_boundingbox_modify_status";

    public static final String SetMobReveal = "set_mob_reveal";

    public static final String PlayAnimation = "play_animation";
    public static final String SetAvailableAnimations = "set_avail_anim";
    public static final String SetAnimationDisplayName = "set_anim_display";

    public static final String AdminRevealSync = "admin_reveal_sync";
    public static final String AdminRevealAdd = "admin_reveal_add";
    public static final String AdminRevealRemove = "admin_reveal_remove";
    public static final String AdminRevealClear = "admin_reveal_clear";

    public static final String CRSyncRender = "cr_syncrender";
    public static final String CRAdd = "cr_add";
    public static final String CRRemove = "cr_remove";
    public static final String CRClear = "cr_clear";
    public static final String CRMeta = "cr_meta";

    @Deprecated(forRemoval = true)
    public static final String SetReach = "reach";

    @Deprecated(forRemoval = true)
    public static final String Map = "map";

    @Deprecated(forRemoval = true)
    public static final String MapPartial = "mapp";

    @Deprecated(forRemoval = true)
    public static final String MapClear = "mapc";

    @Deprecated(forRemoval = true)
    public static final String MapRemove = "mapr";

    @Deprecated(forRemoval = true)
    public static final String SetNbt = SetSNbt;

    @Deprecated(forRemoval = true)
    public static final String SetSpider = "spider";
}
