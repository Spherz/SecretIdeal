package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.fooddiary.databinding.ActivityAddFoodBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddFoodActivity extends AppCompatActivity {

    private ActivityAddFoodBinding addFoodBinding;
    ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

    Calendar dateAndTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFoodBinding = ActivityAddFoodBinding.inflate(getLayoutInflater());
        setContentView(addFoodBinding.getRoot());

        init();

        setInitialDateTime();

        AddFoodAdapter adapter = new AddFoodAdapter(this, foodItems);

        addFoodBinding.rcList.setAdapter(adapter);

        addFoodBinding.txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void init() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        addFoodBinding.rcList.setLayoutManager(manager);

        List<FoodSubItem> firstNestedList = new ArrayList<>();
        List<FoodSubItem> secondNestedList = new ArrayList<>();
        List<FoodSubItem> thirdNestedList = new ArrayList<>();
        List<FoodSubItem> fourthNestedList = new ArrayList<>();
        List<FoodSubItem> fifthNestedList = new ArrayList<>();

        firstNestedList.add(new FoodSubItem(123, 240, 390, 500, 600));
        secondNestedList.add(new FoodSubItem(432, 321, 222, 333, 555));
        thirdNestedList.add(new FoodSubItem(432, 321, 222, 333, 555));
        fourthNestedList.add(new FoodSubItem(432, 321, 222, 333, 555));
        fifthNestedList.add(new FoodSubItem(432, 321, 222, 333, 555));


        foodItems.add(new FoodItem(100, 209, 300, firstNestedList));
        foodItems.add(new FoodItem(150, 219, 400, secondNestedList));
        foodItems.add(new FoodItem(200, 229, 500, thirdNestedList));
        foodItems.add(new FoodItem(250, 239, 600, fourthNestedList));
        foodItems.add(new FoodItem(3000, 249, 700, fifthNestedList));

    }

    public void setDate(View v) {
        new DatePickerDialog(AddFoodActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setTime(View v) {
        new TimePickerDialog(AddFoodActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    private void setInitialDateTime() {
        addFoodBinding.txtCurrentDate.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_WEEKDAY));
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