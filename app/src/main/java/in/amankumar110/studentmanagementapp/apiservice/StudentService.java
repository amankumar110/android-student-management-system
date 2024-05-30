package in.amankumar110.studentmanagementapp.apiservice;

import in.amankumar110.studentmanagementapp.models.ListStudentResponse;
import in.amankumar110.studentmanagementapp.models.SingleStudentResponse;
import in.amankumar110.studentmanagementapp.models.Student;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StudentService {

    @GET("students")
    Call<ListStudentResponse> getAllStudents();

    @POST("students")
    Call<ListStudentResponse> addStudent(@Body Student student);

    @DELETE("students/{id}")
    Call<ListStudentResponse> deleteStudent(@Path("id") int id);

    @GET("students/{id}")
    Call<SingleStudentResponse> getStudentById(@Path("id") int id);
}
