package xyz.nifeather.morph.network;

import xyz.nifeather.morph.network.commands.C2S.*;
import xyz.nifeather.morph.network.commands.S2C.*;
import xyz.nifeather.morph.network.commands.S2C.admin.reveal.S2CClearAdminRevealCommand;
import xyz.nifeather.morph.network.commands.S2C.admin.reveal.S2CAddAdminRevealCommand;
import xyz.nifeather.morph.network.commands.S2C.admin.reveal.S2CRemoveAdminRevealCommand;
import xyz.nifeather.morph.network.commands.S2C.admin.reveal.S2CSyncAdminRevealCommand;
import xyz.nifeather.morph.network.commands.S2C.clientrender.*;
import xyz.nifeather.morph.network.commands.S2C.query.S2CQueryCommand;
import xyz.nifeather.morph.network.commands.S2C.set.*;

/**
 * A handler that process commands from servers send to the client
 * @param <TPlatformPlayer> The class type of player on the client platform
 */
public interface BasicServerHandler<TPlatformPlayer>
{
    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean sendCommand(AbstractC2SCommand<?> c2SCommand);

    public abstract int getServerApiVersion();

    public abstract int getImplmentingApiVersion();

    //region Commands

    void onCurrentCommand(S2CSetCurrentCommand command);
    void onReAuthCommand(S2CReAuthCommand command);
    void onUnAuthCommand(S2CUnAuthCommand command);
    void onSwapCommand(S2CSwapCommand command);

    void onQueryCommand(S2CQueryCommand command);

    void onSetAggressiveCommand(S2CSetAggressiveCommand command);
    void onSetFakeEquipCommand(S2CSetFakeEquipCommand<?> command);
    void onSetDisplayingFakeEquipCommand(S2CSetDisplayingFakeEquipCommand command);
    void onSetSNbtCommand(S2CSetSNbtCommand command); //NBT和SNBT用的是同一个指令名和格式，不需要单独设置
    void onSetProfileCommand(S2CSetProfileCommand command);
    void onSetSelfViewIdentifierCommand(S2CSetSelfViewIdentifierCommand command);
    void onSetSkillCooldownCommand(S2CSetSkillCooldownCommand command);
    void onSetSneakingCommand(S2CSetSneakingCommand command);
    void onSetSelfViewingCommand(S2CSetSelfViewingStatusCommand command);
    void onSetModifyBoundingBox(S2CSetModifyBoundingBoxCommand command);

    void onSetRevealing(S2CSetMobRevealCommand command);

    void onExchangeRequestReceive(S2CUpdateRequestStatusCommand command);

    //region MapCommands

    void onMapCommand(S2CSyncAdminRevealCommand command);
    void onMapPartialCommand(S2CAddAdminRevealCommand command);
    void onMapClearCommand(S2CClearAdminRevealCommand command);
    void onMapRemoveCommand(S2CRemoveAdminRevealCommand command);

    //endregion MapCommands

    //region ClientRenderer

    void onClientMapSyncCommand(S2CCRSyncRegisterCommand command);
    void onClientMapAddCommand(S2CCRRegisterCommand command);
    void onClientMapRemoveCommand(S2CCRUnregisterCommand command);
    void onClientMapClearCommand(S2CCRClearCommand command);
    void onClientMapMetaNbtCommand(S2CCRSetMetaCommand command);

    //endregion ClientRenderer

    void onAnimationCommand(S2CPlayAnimationCommand command);
    void onValidAnimationsCommand(S2CSetAvailableAnimationsCommand command);
    void onSetAnimationDisplayCommand(S2CSetAnimationDisplayNameCommand command);

    //endregion Commands
}
