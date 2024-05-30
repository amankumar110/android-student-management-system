package in.amankumar110.studentmanagementapp.view.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import in.amankumar110.studentmanagementapp.databinding.EmptyListItemLayoutBinding;
import in.amankumar110.studentmanagementapp.databinding.StudentListItemLayoutBinding;
import in.amankumar110.studentmanagementapp.models.Student;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_STUDENT = 0;
    private static final int VIEW_TYPE_NO_STUDENT = 1;

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case VIEW_TYPE_STUDENT:
                StudentListItemLayoutBinding studentBinding = StudentListItemLayoutBinding.inflate(layoutInflater, parent, false);
                return new StudentViewHolder(studentBinding);
            case VIEW_TYPE_NO_STUDENT:
                EmptyListItemLayoutBinding emptyListBinding = EmptyListItemLayoutBinding.inflate(layoutInflater, parent, false);
                return new NoStudentViewHolder(emptyListBinding);
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StudentViewHolder) {
            Student currentStudent = students.get(position);
            ((StudentViewHolder) holder).bind(currentStudent);
        }
    }

    @Override
    public int getItemCount() {
        return students == null || students.isEmpty() ? 1 : students.size();
    }

    @Override
    public int getItemViewType(int position) {
        return students == null || students.isEmpty() ? VIEW_TYPE_NO_STUDENT : VIEW_TYPE_STUDENT;
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        StudentListItemLayoutBinding binding;

        StudentViewHolder(StudentListItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Student student) {
            binding.setStudent(student);
            binding.executePendingBindings();
        }
    }

    static class NoStudentViewHolder extends RecyclerView.ViewHolder {
        EmptyListItemLayoutBinding binding;

        NoStudentViewHolder(EmptyListItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}