package xyz.nifeather.morph.network.commands.S2C;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public record S2CCommandRecord(
        @Expose
        @SerializedName("command_name")
        String commandName,

        @Expose
        @SerializedName("argument_list")
        List<String> arguments
)
{
    public static S2CCommandRecord fromS2CCommand(AbstractS2CCommand<?> command)
    {
        return new S2CCommandRecord(command.getBaseName(), command.serializeArgumentList());
    }
}
