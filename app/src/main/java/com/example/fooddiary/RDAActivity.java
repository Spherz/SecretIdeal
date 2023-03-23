package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivityRdaactivityBinding;

public class RDAActivity extends AppCompatActivity {

    private ActivityRdaactivityBinding rdaactivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rdaactivityBinding = ActivityRdaactivityBinding.inflate(getLayoutInflater());
        setContentView(rdaactivityBinding.getRoot());
    }
}