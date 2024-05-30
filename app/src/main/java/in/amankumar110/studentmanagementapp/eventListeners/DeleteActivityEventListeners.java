package in.amankumar110.studentmanagementapp.eventListeners;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import in.amankumar110.studentmanagementapp.databinding.ActivityDeleteStudentBinding;
import in.amankumar110.studentmanagementapp.models.Student;
import in.amankumar110.studentmanagementapp.view.adapters.StudentAdapter;
import in.amankumar110.studentmanagementapp.viewmodel.StudentViewModel;

public class DeleteActivityEventListeners {

    private android.content.Context context;
    ActivityDeleteStudentBinding binding;
    private int deleteId;
    private StudentViewModel viewModel;

    public DeleteActivityEventListeners(ActivityDeleteStudentBinding binding,Context context, int deleteId, StudentViewModel viewModel) {

        this.binding = binding;
        this.context = context;
        this.deleteId = deleteId;
        this.viewModel = viewModel;

        setDeleteInputListener();
    }


    public void onDeleteButtonListener(View v) {
        MutableLiveData<String> messageLiveData = viewModel.deleteStudentById(deleteId);


        messageLiveData.observe((LifecycleOwner) context, message -> {

            Log.v("msg",message);
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });

    }
    public void setDeleteInputListener() {
        binding.deleteIdInput.addTextChangedListener(new TextWatcher() {
            private final long DELAY = 500; // Delay in milliseconds
            private Handler handler = new Handler(Looper.getMainLooper());
            private Runnable runnable;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Cancel the previous runnable if it exists
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Start a new runnable to perform the search after the delay
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        performSearch(s.toString());
                    }
                };
                handler.postDelayed(runnable, DELAY);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void performSearch(String input) {
        if (!input.isEmpty()) {
            deleteId = Integer.parseInt(input);
            viewModel.getStudentById(deleteId).observe((LifecycleOwner) context, student -> {

                binding.deleteStudentList.setVisibility(View.VISIBLE);
                List<Student> students = new ArrayList<>();
                if (student != null) {
                    students.add(student);
                }
                showStudent(students);
            });
        } else {
            binding.deleteStudentList.setVisibility(View.GONE);
        }
    }
    public void showStudent(List<Student> students) {

        binding.deleteStudentList.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        StudentAdapter adapter = new StudentAdapter(students);
        binding.deleteStudentList.setAdapter(adapter);
    }

}
