package in.amankumar110.studentmanagementapp.enums;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE");
    final String value;


    Gender(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
