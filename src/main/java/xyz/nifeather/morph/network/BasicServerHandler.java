package xyz.nifeather.morph.network;

import xyz.nifeather.morph.network.commands.C2S.*;
import xyz.nifeather.morph.network.commands.S2C.*;
import xyz.nifeather.morph.network.commands.S2C.clientrender.*;
import xyz.nifeather.morph.network.commands.S2C.map.*;
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

    void onCurrentCommand(S2CCurrentCommand command);
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
    void onSetSelfViewingCommand(S2CSetSelfViewingCommand command);
    void onSetModifyBoundingBox(S2CSetModifyBoundingBoxCommand command);
    void onSetReach(S2CSetReachCommand command);
    void onSetRevealing(S2CSetRevealingCommand command);

    void onExchangeRequestReceive(S2CRequestCommand command);

    //region MapCommands

    void onMapCommand(S2CMapCommand command);
    void onMapPartialCommand(S2CPartialMapCommand command);
    void onMapClearCommand(S2CMapClearCommand command);
    void onMapRemoveCommand(S2CMapRemoveCommand command);

    //endregion MapCommands

    //region ClientRenderer

    void onClientMapSyncCommand(S2CRenderMapSyncCommand command);
    void onClientMapAddCommand(S2CRenderMapAddCommand command);
    void onClientMapRemoveCommand(S2CRenderMapRemoveCommand command);
    void onClientMapClearCommand(S2CRenderMapClearCommand command);
    void onClientMapMetaNbtCommand(S2CRenderMapMetaCommand command);

    //endregion ClientRenderer

    void onAnimationCommand(S2CAnimationCommand command);
    void onValidAnimationsCommand(S2CSetAvailableAnimationsCommand command);
    void onSetAnimationDisplayCommand(S2CSetAnimationDisplayNameCommand command);

    //endregion Commands
}
