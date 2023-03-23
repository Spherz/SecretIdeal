package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fooddiary.databinding.ActivityChangeUsernmaeBinding;

public class ChangeUsernmaeActivity extends AppCompatActivity {

    private ActivityChangeUsernmaeBinding changeUsernmaeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeUsernmaeBinding = ActivityChangeUsernmaeBinding.inflate(getLayoutInflater());
        setContentView(changeUsernmaeBinding.getRoot());
    }
}