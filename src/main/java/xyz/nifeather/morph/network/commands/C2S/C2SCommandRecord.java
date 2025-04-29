package xyz.nifeather.morph.network.commands.C2S;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public record C2SCommandRecord(
        @Expose
        @SerializedName("command_name")
        String commandName,

        @Expose
        @SerializedName("argument_list")
        List<String> arguments
)
{
    public static C2SCommandRecord fromC2SCommand(AbstractC2SCommand<?> command)
    {
        return new C2SCommandRecord(command.getBaseName(), command.serializeArgumentList());
    }
}
