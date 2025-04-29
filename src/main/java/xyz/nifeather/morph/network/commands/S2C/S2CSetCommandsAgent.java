package xyz.nifeather.morph.network.commands.S2C;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xyz.nifeather.morph.network.commands.S2C.set.*;
import xyz.nifeather.morph.network.utils.Asserts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class S2CSetCommandsAgent
{
    public S2CSetCommandsAgent()
    {
        this.register(S2CCommandNames.SetAggressive, S2CSetAggressiveCommand::fromArguments)
                .register(S2CCommandNames.SetDisplayingFakeEquip, S2CSetDisplayingFakeEquipCommand::fromArguments)
                .register(S2CCommandNames.SetProfile, S2CSetProfileCommand::fromArguments)
                .register(S2CCommandNames.SetSelfViewIdentifier, S2CSetSelfViewIdentifierCommand::fromArguments)
                .register(S2CCommandNames.SetSkillCooldown, S2CSetSkillCooldownCommand::fromArguments)
                .register(S2CCommandNames.SetSNbt, S2CSetSNbtCommand::fromArguments)
                .register(S2CCommandNames.SetSneaking, S2CSetSneakingCommand::fromArguments)
                .register(S2CCommandNames.SetSelfViewing, S2CSetSelfViewingCommand::fromArguments)
                .register(S2CCommandNames.SetModifyBoundingBox, S2CSetModifyBoundingBoxCommand::fromArguments)
                //.register(S2CCommandNames.SetReach, a -> new S2CSetReachCommand(Integer.parseInt(a)))
                .register(S2CCommandNames.SetAvailableAnimations, S2CSetAvailableAnimationsCommand::fromArguments)
                .register(S2CCommandNames.SetAnimationDisplayName, S2CSetAnimationDisplayNameCommand::fromArguments);
    }

    private final Map<String, Function<List<String>, AbstractS2CSetCommand<?>>> nameToCmdMap = new ConcurrentHashMap<>();

    public S2CSetCommandsAgent register(String baseName, Function<List<String>, AbstractS2CSetCommand<?>> func)
    {
        nameToCmdMap.put(baseName, func);

        return this;
    }

    public AbstractS2CSetCommand<?> fromArguments(List<String> arguments) throws RuntimeException
    {
        Asserts.assertArgumentCountAtLeast(arguments, AbstractS2CCommand.class, 1);

        var baseName = arguments.remove(0);
        var func = nameToCmdMap.getOrDefault(baseName, null);

        return Objects.requireNonNull(func, "No command found for BaseName '%s'".formatted(baseName)).apply(arguments);
    }

    public AbstractS2CSetCommand<?> getCommand(String args) throws RuntimeException
    {
        var argumentList = new ObjectArrayList<>(Arrays.stream(args.split(" ", 2)).toList());

        if (argumentList.isEmpty()) return null; // first of the arguments is the command name

        var baseName = argumentList.remove(0);

        var func = nameToCmdMap.getOrDefault(baseName, null);
        if (func == null)
            throw new RuntimeException("No command found for BaseName '%s'".formatted(baseName));

        return func.apply(argumentList);
    }
}
