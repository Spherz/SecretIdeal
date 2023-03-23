package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityUserWeightBinding;

// TODO: Сделать фрагментом
public class UserWeightActivity extends AppCompatActivity {

    private ActivityUserWeightBinding userWeightBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userWeightBinding = ActivityUserWeightBinding.inflate(getLayoutInflater());
        setContentView(userWeightBinding.getRoot());

        userWeightBinding.imgAddUserWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserWeightActivity.this, AddUserWeightActivity.class);
                startActivity(intent);
            }
        });

        userWeightBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}