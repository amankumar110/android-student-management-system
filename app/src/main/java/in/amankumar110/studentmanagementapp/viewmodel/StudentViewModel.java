package in.amankumar110.studentmanagementapp.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

import in.amankumar110.studentmanagementapp.helper.Validator;
import in.amankumar110.studentmanagementapp.models.Repository;
import in.amankumar110.studentmanagementapp.models.Student;

public class StudentViewModel extends ViewModel {

   Repository repository;

    public StudentViewModel() {
        repository = new Repository();
    }

    public LiveData<List<Student>> getAllStudents() {
        return  repository.getAllStudents();
   }

   public MutableLiveData<String> addStudent(Student student) {

        if(Validator.isStudentValid(student)) {
            student.setCountry("Pakistan");
            student.setIsTermAgreed(true);

            return repository.addStudent(student);
        } else {
            return new MutableLiveData<>("Invalid Student Information");
        }

   }

   public MutableLiveData<String> deleteStudentById(int id) {

        return repository.deleteStudentById(id);
   }

   public MutableLiveData<Student> getStudentById(int id) {


        return repository.getStudentById(id);
   }

}
