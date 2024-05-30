package in.amankumar110.studentmanagementapp.enums;

public enum Hobby {



    CODING("Coding"),
    READING("Reading"),
    SPORTS("Sports");
    private String hobby;
    Hobby(String value) {
        this.hobby = value;
    }

    public String getValue() {
        return hobby;
    }

    public void setValue(String hobby) {
        this.hobby = hobby;
    }
}
