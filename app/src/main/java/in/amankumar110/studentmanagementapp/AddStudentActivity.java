package in.amankumar110.studentmanagementapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import in.amankumar110.studentmanagementapp.enums.Gender;
import in.amankumar110.studentmanagementapp.enums.Hobby;
import in.amankumar110.studentmanagementapp.eventListeners.AddActivityEventListeners;
import in.amankumar110.studentmanagementapp.databinding.ActivityAddStudentBinding;
import in.amankumar110.studentmanagementapp.models.Student;
import in.amankumar110.studentmanagementapp.viewmodel.StudentViewModel;

public class AddStudentActivity extends AppCompatActivity {


    private ActivityAddStudentBinding binding;

    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityAddStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        binding.studentDateSelectButton.setBackgroundTintList(null);
        binding.submitButton.setBackgroundTintList(null);

        // Add Student
        Student student= new Student();
        AddActivityEventListeners listeners = new AddActivityEventListeners(student,this,viewModel);

        binding.setGender(Gender.MALE);
        binding.setStudent(student);
        binding.setListeners(listeners);
        binding.setHobby(Hobby.CODING);




    }
}