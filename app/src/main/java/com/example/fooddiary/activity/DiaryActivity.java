package com.example.fooddiary.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.fooddiary.R;
import com.example.fooddiary.adapter.DiaryAdapter;
import com.example.fooddiary.databinding.ActivityDiaryBinding;
import com.example.fooddiary.model.ButtonItem;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiaryActivity extends AppCompatActivity {
    private ActivityDiaryBinding diaryBinding;
    ArrayList<ButtonItem> buttonItems = new ArrayList<>();
    DiaryAdapter adapter;

    Calendar dateAndTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        diaryBinding = ActivityDiaryBinding.inflate(getLayoutInflater());
        setContentView(diaryBinding.getRoot());

        diaryBinding.bottomNavigationView.setSelectedItemId(R.id.item2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        initButtons();
        setInitialDateTime();
        initRecyclerView();

        diaryBinding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        setResult(RESULT_OK, getIntent());
                        finish();
                        return true;
                    case R.id.item2:
                        return true;
                    case R.id.item3:
                        Intent settingsIntent = new Intent(DiaryActivity.this, SettingsActivity.class);
                        settingsIntent.putExtra("username", username);
                        startActivity(settingsIntent);
                        return true;
                }
                return false;
            }
        });

        diaryBinding.curDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(v);
            }
        });

        diaryBinding.imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(DiaryActivity.this, AddFoodActivity.class);
                startActivityForResult(searchIntent, 100);
            }
        });
    }

    public void initButtons() {
        ButtonItem breakfast = new ButtonItem("Завтрак", R.drawable.sunrise, R.drawable.baseline_add);
        ButtonItem lunch = new ButtonItem("Обед", R.drawable.sun, R.drawable.baseline_add);
        ButtonItem dinner = new ButtonItem("Ужин", R.drawable.sunset, R.drawable.baseline_add);
        ButtonItem snack = new ButtonItem("Перекус/Другое", R.drawable.night, R.drawable.baseline_add);

        buttonItems.add(breakfast);
        buttonItems.add(lunch);
        buttonItems.add(dinner);
        buttonItems.add(snack);
    }

    public void updateFoodInfo() {
        Intent intent = getIntent();
        ArrayList<String> food = (ArrayList<String>) intent.getSerializableExtra("foodName");
        buttonItems.get(0).setFoodTitle(food.get(0));
        adapter.notifyItemChanged(0);
    }

    public void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new DiaryAdapter(this, buttonItems);

        diaryBinding.rcBtnList.setHasFixedSize(true);

        // TODO Посмотреть как в RC передать данные с активити (ПОМЕНЯТЬ ИКОНКИ И ДОБАВИТЬ ТЕМНЫЙ РЕЖИМ ДЛЯ ВСЕГО ПРИЛОЖЕНИЯ!!!!!)

        diaryBinding.rcBtnList.setAdapter(adapter);
        diaryBinding.rcBtnList.setLayoutManager(manager);
    }

    public void setDate(View v) {
        new DatePickerDialog(DiaryActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setTime(View v) {
        new TimePickerDialog(DiaryActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    private void setInitialDateTime() {
        diaryBinding.curDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> foodExtra = data.getStringArrayListExtra("foodName");
        System.out.println(foodExtra);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            diaryBinding.textView17.setText(foodExtra.get(0));
            System.out.println(data.getSerializableExtra("foodName"));

        }
    }
}