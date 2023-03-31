package com.example.fooddiary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityRdaactivityBinding;

public class RDAActivity extends AppCompatActivity {

    private ActivityRdaactivityBinding rdaActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rdaActivityBinding = ActivityRdaactivityBinding.inflate(getLayoutInflater());
        setContentView(rdaActivityBinding.getRoot());

        rdaActivityBinding.btnSelectAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectAgeIntent = new Intent(RDAActivity.this, SelectAgeActivity.class);
//                startActivityForResult(selectAgeIntent); TODO: edit
            }
        });

        rdaActivityBinding.btnSelectGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectGenderIntent = new Intent(RDAActivity.this, SelectGenderActivity.class);
                startActivity(selectGenderIntent);
            }
        });

        rdaActivityBinding.btnSelectActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectActivityIntent = new Intent(RDAActivity.this, SelectActivity.class);
                startActivity(selectActivityIntent);
            }
        });

        rdaActivityBinding.btnWeightDimensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectDimens = new Intent(RDAActivity.this, SelectDimensionActivity.class);
                startActivity(selectDimens);
            }
        });

        rdaActivityBinding.btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectWeight = new Intent(RDAActivity.this, SelectWeightActivity.class);
                startActivity(selectWeight);
            }
        });

        rdaActivityBinding.btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectHeight = new Intent(RDAActivity.this, SelectHeightActivity.class);
                startActivity(selectHeight);
            }
        });

        rdaActivityBinding.btnGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalIntent = new Intent(RDAActivity.this, SelectGoalActivity.class);
                startActivity(goalIntent);
            }
        });

        rdaActivityBinding.btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weightIntent = new Intent(RDAActivity.this, SelectWeightActivity.class);
                startActivity(weightIntent);
            }
        });

        rdaActivityBinding.btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent heightIntent = new Intent(RDAActivity.this, SelectHeightActivity.class);
                startActivity(heightIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK && data != null) {

        }
    }
}