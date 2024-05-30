package in.amankumar110.studentmanagementapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import in.amankumar110.studentmanagementapp.databinding.ActivityListStudentsBinding;
import in.amankumar110.studentmanagementapp.models.Student;
import in.amankumar110.studentmanagementapp.view.adapters.StudentAdapter;
import in.amankumar110.studentmanagementapp.viewmodel.StudentViewModel;

public class ListStudentsActivity extends AppCompatActivity {

    private ActivityListStudentsBinding binding;
    private StudentViewModel viewModel;
    private List<Student> students;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityListStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        students = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        setSearchInputListener();

        viewModel.getAllStudents().observe(this, updatedStudents -> {
            students.clear();
            students.addAll(updatedStudents);
            showStudents(students);
        });
    }

    public void showStudents(List<Student> students) {

        binding.studentsRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentAdapter(students);
        binding.studentsRecyclerList.setAdapter(adapter);
    }

    public void setSearchInputListener() {
        binding.searchInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = s.toString().toLowerCase();
                if (searchText.isEmpty()) {
                    showStudents(students);
                } else {
                    List<Student> filteredStudents = students.stream()
                            .filter(student -> student.getName().toLowerCase().contains(searchText))
                            .collect(Collectors.toList());
                    showStudents(filteredStudents);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}