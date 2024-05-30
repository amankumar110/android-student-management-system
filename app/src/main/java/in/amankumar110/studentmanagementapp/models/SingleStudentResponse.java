package in.amankumar110.studentmanagementapp.models;

import java.util.List;

public class SingleStudentResponse {

    private Student data;
    private boolean success;
    private String message;
    private long status;
    private String timestamp;

    public Student getData() { return data; }
    public void setData(Student value) { this.data = value; }

    public boolean getSuccess() { return success; }
    public void setSuccess(boolean value) { this.success = value; }

    public String getMessage() { return message; }
    public void setMessage(String value) { this.message = value; }

    public long getStatus() { return status; }
    public void setStatus(long value) { this.status = value; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String value) { this.timestamp = value; }
}
