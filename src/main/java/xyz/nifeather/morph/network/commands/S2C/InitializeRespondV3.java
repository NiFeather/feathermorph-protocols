package xyz.nifeather.morph.network.commands.S2C;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public record InitializeRespondV3(
        @Expose
        @SerializedName("server_features")
        @Unmodifiable
        List<String> serverFeatures,

        @Expose
        @SerializedName("api_version")
        int apiVersion
)
{
}
