package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivitySelectWeightBinding;

public class SelectWeightActivity extends AppCompatActivity {

    private ActivitySelectWeightBinding selectWeightBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectWeightBinding = ActivitySelectWeightBinding.inflate(getLayoutInflater());
        setContentView(selectWeightBinding.getRoot());
    }
}