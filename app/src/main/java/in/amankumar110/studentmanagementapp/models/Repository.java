package in.amankumar110.studentmanagementapp.models;



import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import java.util.List;

import in.amankumar110.studentmanagementapp.apiservice.StudentService;
import in.amankumar110.studentmanagementapp.database.Database;
import retrofit2.Call;
import retrofit2.Callback;

public class Repository {

    private StudentService service;


    public Repository() {

        service = Database.getStudentService();
    }

    public MutableLiveData<List<Student>> getAllStudents() {

        MutableLiveData<List<Student>> studentLiveData = new MutableLiveData<>();

        Call<ListStudentResponse> response = service.getAllStudents();

        response.enqueue(new Callback<ListStudentResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListStudentResponse> call, retrofit2.Response<ListStudentResponse> response) {

                if(response.body()!=null) {
                    studentLiveData.setValue(response.body().getData());
                }
            }


            @Override
            public void onFailure(Call<ListStudentResponse> call, Throwable throwable) {

                studentLiveData.setValue(null);

            }
        });

        return studentLiveData;

    }

    public MutableLiveData<String> addStudent(Student student) {


        MutableLiveData<String> message = new MutableLiveData<>();
        Call<ListStudentResponse> call =  service.addStudent(student);

        call.enqueue(new Callback<ListStudentResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListStudentResponse> call, retrofit2.Response<ListStudentResponse> response) {


               if (response.isSuccessful()) {

                   message.setValue(response.body().getMessage());

               } else {

                   ErrorResponse errorResponse = new Gson().fromJson(response.errorBody().charStream(), ErrorResponse.class);
                   message.setValue(errorResponse.getMessage());
               }
            }

            @Override
            public void onFailure(Call<ListStudentResponse> call, Throwable throwable) {
                message.setValue(throwable.getMessage());
            }

        });

        return  message;
    }

    public MutableLiveData<String> deleteStudentById(int id){

        MutableLiveData<String> deleteMessage = new MutableLiveData<>();

        Call<ListStudentResponse> call = service.deleteStudent(id);

        call.enqueue(new Callback<ListStudentResponse>() {
            @Override
            public void onResponse(Call<ListStudentResponse> call, retrofit2.Response<ListStudentResponse> response) {

                if(response.isSuccessful()) {

                    deleteMessage.setValue(response.body().getMessage());
                } else {

                    ErrorResponse er = new Gson()
                            .fromJson(response.errorBody().charStream(),ErrorResponse.class);
                    deleteMessage.setValue(er.getMessage());
                }

            }

            @Override
            public void onFailure(Call<ListStudentResponse> call, Throwable throwable) {
                deleteMessage.setValue(throwable.getMessage());
            }
        });

        return deleteMessage;
    }


    public MutableLiveData<Student> getStudentById(int id) {

        MutableLiveData<Student> studentLiveData = new MutableLiveData<>();

        Call<SingleStudentResponse> response = service.getStudentById(id);

        response.enqueue(new Callback<SingleStudentResponse>() {
            @Override
            public void onResponse(@NonNull Call<SingleStudentResponse> call, retrofit2.Response<SingleStudentResponse> response) {

                if(response.body()!=null)
                    studentLiveData.setValue(response.body().getData());
                else
                    studentLiveData.setValue(null);

            }


            @Override
            public void onFailure(Call<SingleStudentResponse> call, Throwable throwable) {

                studentLiveData.setValue(null);

                Log.v("failure",throwable.getLocalizedMessage());

            }
        });

        return studentLiveData;

    }


}
