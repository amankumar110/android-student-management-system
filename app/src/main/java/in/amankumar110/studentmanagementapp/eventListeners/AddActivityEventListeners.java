package in.amankumar110.studentmanagementapp.eventListeners;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import in.amankumar110.studentmanagementapp.ListStudentsActivity;
import in.amankumar110.studentmanagementapp.R;
import in.amankumar110.studentmanagementapp.enums.ServerResponse;
import in.amankumar110.studentmanagementapp.models.Student;
import in.amankumar110.studentmanagementapp.viewmodel.StudentViewModel;

public class AddActivityEventListeners {

    private Student student;
    private Context context;
    private StudentViewModel viewModel;

    public AddActivityEventListeners(Student student, Context context,StudentViewModel vm) {
        this.student = student;
        this.context = context;
        this.viewModel = vm;
    }



    public void onDateButtonClickListener(View v) {

        Dialog dialog = new Dialog(context);
        DatePicker datePicker = new DatePicker(context);
        dialog.setContentView(datePicker);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    student.setDateOfBirth(LocalDate.of(year,monthOfYear,dayOfMonth).toString());

                    dialog.dismiss();
                }
            });
            dialog.show();
        }

    }


    public void onGenderSelectedListener(RadioGroup group, int checkedId) {
        String gender = ((RadioButton) group.findViewById(checkedId)).getText().toString();
        student.setGender(gender);
       }

    public void onHobbyChecked(CompoundButton checkbox, boolean isChecked) {

        if(student.getHobbies() == null) {
            student.setHobbies(new ArrayList<>());
        }

        if(isChecked) {
            String hobby = checkbox.getText().toString();

            if(!student.getHobbies().contains(hobby)) {
                student.getHobbies().add(hobby);
            }
        }
     }

    public void onSubmitButtonClicked(View v) {


            viewModel.addStudent(student).observe((LifecycleOwner) context, message->{

                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

                if(message.equals(ServerResponse.SUCCESS_MESSAGE.getValue())) {
                    Intent intent = new Intent(context, ListStudentsActivity.class);
                    context.startActivity(intent);
                };

            });

    }



}
