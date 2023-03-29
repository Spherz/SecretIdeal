package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivitySelectBinding;

public class SelectActivity extends AppCompatActivity {

    private ActivitySelectBinding selectActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectActivityBinding = ActivitySelectBinding.inflate(getLayoutInflater());
        setContentView(selectActivityBinding.getRoot());
    }
}