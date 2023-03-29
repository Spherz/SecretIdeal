package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivitySelectGoalBinding;

public class SelectGoalActivity extends AppCompatActivity {

    private ActivitySelectGoalBinding selectGoalBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectGoalBinding = ActivitySelectGoalBinding.inflate(getLayoutInflater());
        setContentView(selectGoalBinding.getRoot());
    }
}