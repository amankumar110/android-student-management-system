package in.amankumar110.studentmanagementapp.helper;

import java.util.regex.Pattern;

import in.amankumar110.studentmanagementapp.models.Student;

public class Validator {

    public static boolean isStudentValid(Student student) {


        if (student == null)
            return false;

        return   isStudentNameValid(student.getName()) && booleanisStudentEmailValid(student.getEmail()) && isStudentDobValid(student.getDateOfBirth()) || isStudentCityValuid(student.getCity());


    }

    private static boolean isStudentNameValid(String name) {

       return name != null && Pattern.matches("^[A-Za-z ]+$", name);
    }

    private static  boolean isStudentDobValid(String dob) {
        return dob!=null && Pattern.matches("^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(19|20)\\d{2}$",dob);
    }

    private static boolean isStudentCityValuid(String city) {
        return city !=null && Pattern.matches("^[A-Za-z\\s-]+$",city);

    }

    private static boolean booleanisStudentEmailValid(String email) {
        return email !=null && Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",email);
    }


}
