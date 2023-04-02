package xiamomc.morph.network;

import xiamomc.morph.network.commands.C2S.*;
import xiamomc.morph.network.commands.S2C.S2CCurrentCommand;
import xiamomc.morph.network.commands.S2C.S2CReAuthCommand;
import xiamomc.morph.network.commands.S2C.S2CSwapCommand;
import xiamomc.morph.network.commands.S2C.S2CUnAuthCommand;
import xiamomc.morph.network.commands.S2C.query.S2CQueryCommand;
import xiamomc.morph.network.commands.S2C.set.*;

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

    //endregion Commands
}
