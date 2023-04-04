package com.example.fooddiary.activity;

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
                startActivityForResult(selectAgeIntent, 100);
            }
        });

        rdaActivityBinding.btnSelectGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectGenderIntent = new Intent(RDAActivity.this, SelectGenderActivity.class);
                startActivityForResult(selectGenderIntent, 200);
            }
        });

        rdaActivityBinding.btnSelectActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectActivityIntent = new Intent(RDAActivity.this, SelectActivity.class);
                startActivityForResult(selectActivityIntent, 300);
            }
        });

        rdaActivityBinding.btnWeightDimensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectDimens = new Intent(RDAActivity.this, SelectDimensionActivity.class);
                startActivityForResult(selectDimens, 400);
            }
        });

        rdaActivityBinding.btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectWeight = new Intent(RDAActivity.this, SelectWeightActivity.class);
                startActivityForResult(selectWeight, 500);
            }
        });

        rdaActivityBinding.btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectHeight = new Intent(RDAActivity.this, SelectHeightActivity.class);
                startActivityForResult(selectHeight,600);
            }
        });

        rdaActivityBinding.btnGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalIntent = new Intent(RDAActivity.this, SelectGoalActivity.class);
                startActivityForResult(goalIntent, 700);
            }
        });

        rdaActivityBinding.imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserAge.setText(data.getStringExtra("userAge"));
        } else if(requestCode == 200 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserGender.setText(data.getStringExtra("userGender"));
        } else if(requestCode == 300 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserActivity.setText(data.getStringExtra("userActivity"));
        }
        else if(requestCode == 400 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserWeightDimensions.setText(data.getStringExtra("userDimensions"));
        } else if(requestCode == 500 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserWeight.setText(data.getStringExtra("userWeight"));
        } else if(requestCode == 600 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserHeight.setText(data.getStringExtra("userHeight"));
        } else if(requestCode == 700 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtGoal.setText(data.getStringExtra("userGoal"));
        }
    }

}