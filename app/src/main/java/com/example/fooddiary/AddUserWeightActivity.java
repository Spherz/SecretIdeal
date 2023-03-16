package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityAddUserWeightBinding;

public class AddUserWeightActivity extends AppCompatActivity {

    private ActivityAddUserWeightBinding addUserWeightBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addUserWeightBinding = ActivityAddUserWeightBinding.inflate(getLayoutInflater());
        setContentView(addUserWeightBinding.getRoot());

        addUserWeightBinding.imgCancelWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}