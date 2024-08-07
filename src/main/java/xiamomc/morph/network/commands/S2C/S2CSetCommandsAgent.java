package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.commands.S2C.set.*;

import java.util.function.Function;

public class S2CSetCommandsAgent extends S2CCommandWithChild<Object>
{
    public S2CSetCommandsAgent()
    {
        this.register(S2CCommandNames.SetAggressive, a -> new S2CSetAggressiveCommand(Boolean.parseBoolean(a)))
                .register(S2CCommandNames.SetDisplayingFakeEquip, a -> new S2CSetDisplayingFakeEquipCommand(Boolean.parseBoolean(a)))
                .register(S2CCommandNames.SetProfile, S2CSetProfileCommand::new)
                .register(S2CCommandNames.SetSelfViewIdentifier, S2CSetSelfViewIdentifierCommand::new)
                .register(S2CCommandNames.SetSkillCooldown, a -> new S2CSetSkillCooldownCommand(Long.parseLong(a)))
                .register(S2CCommandNames.SetSNbt, S2CSetSNbtCommand::new)
                .register(S2CCommandNames.SetSneaking, a -> new S2CSetSneakingCommand(Boolean.parseBoolean(a)))
                .register(S2CCommandNames.SetSelfViewing, a -> new S2CSetSelfViewingCommand(Boolean.parseBoolean(a)))
                .register(S2CCommandNames.SetModifyBoundingBox, a -> new S2CSetModifyBoundingBoxCommand(Boolean.parseBoolean(a)))
                .register(S2CCommandNames.SetReach, a -> new S2CSetReachCommand(Integer.parseInt(a)))
                .register(S2CCommandNames.SetAvailableAnimations, S2CSetAvailableAnimationsCommand::fromString);
    }

    public S2CSetCommandsAgent register(String baseName, Function<String, AbstractS2CSetCommand<?>> func)
    {
        super.register(baseName, func);

        return this;
    }

    @Override
    public String getBaseName()
    {
        return S2CCommandNames.BaseSet;
    }
}
