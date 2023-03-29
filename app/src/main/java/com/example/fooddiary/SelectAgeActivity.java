package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;

import com.example.fooddiary.databinding.ActivitySelectAgeBinding;

public class SelectAgeActivity extends AppCompatActivity {

    private ActivitySelectAgeBinding selectAgeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectAgeBinding = ActivitySelectAgeBinding.inflate(getLayoutInflater());
        setContentView(selectAgeBinding.getRoot());

        selectAgeBinding.agePicker.setMaxValue(100);
        selectAgeBinding.agePicker.setMinValue(0);
        selectAgeBinding.agePicker.setValue(18);

        selectAgeBinding.agePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });
    }
}