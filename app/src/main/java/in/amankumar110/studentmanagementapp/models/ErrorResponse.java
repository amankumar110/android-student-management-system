package in.amankumar110.studentmanagementapp.models;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ErrorResponse {
    @SerializedName("status")
    private int status;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("errors")
    private Map<String, String> errors;

    // Getters for accessing the fields
    public int getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}