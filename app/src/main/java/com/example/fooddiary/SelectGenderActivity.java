package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivitySelectGenderBinding;

public class SelectGenderActivity extends AppCompatActivity {

    private ActivitySelectGenderBinding selectGenderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectGenderBinding = ActivitySelectGenderBinding.inflate(getLayoutInflater());
        setContentView(selectGenderBinding.getRoot());
    }
}