package xyz.nifeather.morph.network;

import org.jetbrains.annotations.Nullable;
import xyz.nifeather.morph.network.commands.C2S.*;
import xyz.nifeather.morph.network.commands.S2C.AbstractS2CCommand;

import java.util.List;

/**
 * A handler that process commands from clients send to the server
 * @param <TPlatformPlayer> The class type of player on the server platform
 */
public interface BasicClientHandler<TPlatformPlayer>
{
    /**
     * 获取某一玩家的客户端版本
     * @param player 目标玩家
     * @return 此玩家的客户端版本
     */
    public abstract int getPlayerVersion(TPlatformPlayer player);

    /**
     * 获取所有已连接的玩家
     * @return 一个包含所有已连接玩家的列表
     * @apiNote 此列表可能包含已连接但未初始化的玩家
     */
    public abstract List<TPlatformPlayer> getConnectedPlayers();

    /**
     * 获取某一玩家的连接状态
     * @param player 目标玩家
     * @return 此玩家的连接状态
     */
    public abstract InitializeState getInitializeState(TPlatformPlayer player);

    /**
     * 检查玩家的客户端是否已连接并初始化
     * @param player 目标玩家
     * @return 此玩家是否已经初始化
     */
    public abstract boolean isPlayerInitialized(TPlatformPlayer player);

    /**
     * 检查玩家的连接状态
     * @param player 目标玩家
     * @return 此玩家的连接状态
     */
    public abstract boolean isPlayerConnected(TPlatformPlayer player);

    /**
     * 断开与玩家的初始化连接
     * @param player 目标玩家
     */
    public abstract void disconnect(TPlatformPlayer player);

    /**
     * 获取玩家的某个配置
     * @param player 目标玩家
     */
    @Nullable
    public abstract PlayerOptions<TPlatformPlayer> getPlayerOption(TPlatformPlayer player);

    /**
     * 向目标玩家发送指令
     * @param player 目标玩家
     * @param command 目标指令
     * @return 操作是否成功
     */
    public abstract boolean sendCommand(TPlatformPlayer player, AbstractS2CCommand<?> command);

    //region Commands

    void onInitialCommand(C2SRequestInitialCommand command);
    void onMorphCommand(C2SMorphCommand command);
    void onOptionCommand(C2SSetSingleOptionCommand command);
    void onSkillCommand(C2SActivateSkillCommand command);
    void onToggleSelfCommand(C2SToggleSelfCommand command);
    void onUnmorphCommand(C2SUnmorphCommand command);
    void onRequestCommand(C2SExchangeRequestManagementCommand command);
    void onAnimationCommand(C2SAnimationCommand command);

    //endregion
}
