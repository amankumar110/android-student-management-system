package in.amankumar110.studentmanagementapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import in.amankumar110.studentmanagementapp.databinding.ActivityDeleteStudentBinding;
import in.amankumar110.studentmanagementapp.eventListeners.DeleteActivityEventListeners;
import in.amankumar110.studentmanagementapp.models.Student;
import in.amankumar110.studentmanagementapp.view.adapters.StudentAdapter;
import in.amankumar110.studentmanagementapp.viewmodel.StudentViewModel;

public class DeleteStudentActivity extends AppCompatActivity {


    ActivityDeleteStudentBinding binding;

    private int deleteId;

    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDeleteStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(StudentViewModel.class);


        DeleteActivityEventListeners listeners = new DeleteActivityEventListeners(
                binding,
                this,
                deleteId,
                viewModel
        );

        binding.setListeners(listeners);
    }




}