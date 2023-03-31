package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivitySelectHeightBinding;

public class SelectHeightActivity extends AppCompatActivity {

    private ActivitySelectHeightBinding selectHeightBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectHeightBinding = ActivitySelectHeightBinding.inflate(getLayoutInflater());
        setContentView(selectHeightBinding.getRoot());

        selectHeightBinding.numSelectHeight.setMaxValue(251);
        selectHeightBinding.numSelectHeight.setMinValue(60);
        selectHeightBinding.numSelectHeight.setValue(155);
    }
}