package in.amankumar110.studentmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import in.amankumar110.studentmanagementapp.databinding.ActivityMainBinding;
import in.amankumar110.studentmanagementapp.enums.ServerResponse;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, DeleteStudentActivity.class);
        startActivity(intent);


    }
}