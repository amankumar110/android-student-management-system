package in.amankumar110.studentmanagementapp.database;


import in.amankumar110.studentmanagementapp.apiservice.StudentService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Database {



    private static Retrofit retrofitInstance;

    public static StudentService getStudentService() {

        if (retrofitInstance == null) {

           retrofitInstance =  new Retrofit.Builder()
                    .baseUrl("http://13.126.40.27/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance.create(StudentService.class);
    }
}
