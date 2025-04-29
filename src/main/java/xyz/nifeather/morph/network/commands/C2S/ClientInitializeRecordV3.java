package xyz.nifeather.morph.network.commands.C2S;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public record ClientInitializeRecordV3(
        @Expose
        @SerializedName("client_features")
        List<String> clientFeatures,

        @Expose
        @SerializedName("api_version")
        int apiVersion,

        boolean handleSuccess
)
{
    public static ClientInitializeRecordV3 fail()
    {
        return new ClientInitializeRecordV3(List.of(), -1, false);
    }
}
