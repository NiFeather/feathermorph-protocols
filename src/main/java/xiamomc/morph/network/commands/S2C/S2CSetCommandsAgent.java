package xiamomc.morph.network.commands.S2C;

import xiamomc.morph.network.commands.S2C.set.*;

import java.util.function.Function;

public class S2CSetCommandsAgent extends S2CCommandWithChild<Object>
{
    public S2CSetCommandsAgent()
    {
        this.register("aggressive", a -> new S2CSetAggressiveCommand(Boolean.getBoolean(a)))
                .register("fake_equip", a -> new S2CSetFakeEquipCommand(Boolean.getBoolean(a)))
                .register("profile", S2CSetProfileCommand::new)
                .register("selfview", S2CSetSelfViewCommand::new)
                .register("cd", a -> new S2CSetSkillCooldownCommand(Long.parseLong(a)))
                .register("nbt", S2CSetSNbtCommand::new)
                .register("sneaking", a -> new S2CSetSneakingCommand(Boolean.getBoolean(a)))
                .register("toggleself", a -> new S2CSetToggleSelfCommand(Boolean.valueOf(a)));
    }

    public S2CSetCommandsAgent register(String baseName, Function<String, AbstractS2CSetCommand<?>> func)
    {
        super.register(baseName, func);

        return this;
    }

    @Override
    public String getBaseName()
    {
        return "set";
    }
}
