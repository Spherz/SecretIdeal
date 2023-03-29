package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivitySelectDimensionBinding;

public class SelectDimensionActivity extends AppCompatActivity {

    private ActivitySelectDimensionBinding selectDimensionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectDimensionBinding = ActivitySelectDimensionBinding.inflate(getLayoutInflater());
        setContentView(selectDimensionBinding.getRoot());
    }
}