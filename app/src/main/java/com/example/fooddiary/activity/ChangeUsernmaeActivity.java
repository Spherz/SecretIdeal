package com.example.fooddiary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityChangeUsernmaeBinding;

public class ChangeUsernmaeActivity extends AppCompatActivity {

    private ActivityChangeUsernmaeBinding changeUsernmaeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeUsernmaeBinding = ActivityChangeUsernmaeBinding.inflate(getLayoutInflater());
        setContentView(changeUsernmaeBinding.getRoot());

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        changeUsernmaeBinding.imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        changeUsernmaeBinding.txtChangeUsername.setText(username);
    }
}