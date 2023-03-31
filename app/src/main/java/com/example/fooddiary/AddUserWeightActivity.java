package com.example.fooddiary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.fooddiary.databinding.ActivityAddUserWeightBinding;

import java.sql.Time;
import java.util.Calendar;

public class AddUserWeightActivity extends AppCompatActivity {

    private ActivityAddUserWeightBinding addUserWeightBinding;

    Calendar dateAndTime = Calendar.getInstance();

    double editedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addUserWeightBinding = ActivityAddUserWeightBinding.inflate(getLayoutInflater());
        setContentView(addUserWeightBinding.getRoot());

        setInitialDateTime();

        addUserWeightBinding.imgCancelWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addUserWeightBinding.currentDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(v);
            }
        });

        addUserWeightBinding.btnAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double defaultWeight = Double.parseDouble(addUserWeightBinding.txtEditedWeight.getText().toString());
                editedWeight = defaultWeight + 0.1;
                System.out.println(defaultWeight);
                addUserWeightBinding.txtEditedWeight.setText(String.valueOf(String.format("%.1f",editedWeight)));
                setResult(RESULT_OK, getIntent());
            }
        });

        addUserWeightBinding.btnRemoveWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = Double.parseDouble(addUserWeightBinding.txtEditedWeight.getText().toString());
                editedWeight = weight - 0.1;
                addUserWeightBinding.txtEditedWeight.setText(String.valueOf(String.format("%.1f",editedWeight)));
            }
        });

        addUserWeightBinding.imgSubmitWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent().putExtra("editedWeight", String.valueOf(String.format("%.1f", editedWeight)));
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });
    }

    public void setDate(View v) {
        new DatePickerDialog(AddUserWeightActivity.this, d,
                            dateAndTime.get(Calendar.YEAR),
                            dateAndTime.get(Calendar.MONTH),
                            dateAndTime.get(Calendar.DAY_OF_MONTH))
                            .show();
    }

    public void setTime(View v) {
        new TimePickerDialog(AddUserWeightActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    private void setInitialDateTime() {
        addUserWeightBinding.currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                            | DateUtils.FORMAT_SHOW_TIME));
    }

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker v, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
}