package in.amankumar110.studentmanagementapp.enums;

public enum ServerResponse {

    SUCCESS_MESSAGE("Student Created Successfully");

    private String value;
    ServerResponse(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
