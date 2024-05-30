package in.amankumar110.studentmanagementapp.models;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

public class Student {

    private String country;
    private String gender;
    private String city;
    private boolean isTermAgreed;

    private String email;
    private List<String> hobbies;
    private String name;
    private String dateOfBirth;
    private long id;

    public Student(String country, String gender, String city, boolean isTermAgreed, List<String> hobbies, String name, String dateOfBirth) {
        this.country = country;
        this.gender = gender;
        this.city = city;
        this.isTermAgreed = isTermAgreed;
        this.hobbies = hobbies;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {
    }

    @BindingAdapter({"hobbies"})
    public static void setHobbies(TextView textview, List<String> hobbies) {
        if (hobbies != null) {
            StringBuilder hobbiesText = new StringBuilder();
            for (String hobby : hobbies) {
                hobbiesText.append(" ").append(hobby);
            }
            textview.setText(hobbiesText.toString());
        } else {
            textview.setText("");
        }
    }
    public String getCountry() { return country; }
    public void setCountry(String value) { this.country = value; }

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public boolean getIsTermAgreed() { return isTermAgreed; }
    public void setIsTermAgreed(boolean value) { this.isTermAgreed = value; }

    public List<String> getHobbies() { return hobbies; }
    public void setHobbies(List<String> value) { this.hobbies = value; }
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String value) { this.dateOfBirth = value; }
    public long getId() { return id; }
    public void setId(long value) { this.id = value; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", isTermAgreed=" + isTermAgreed +
                ", email='" + email + '\'' +
                ", hobbies=" + hobbies +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", id=" + id +
                '}';
    }
}