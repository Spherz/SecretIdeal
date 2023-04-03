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
                startActivityForResult(selectActivityIntent, 100);
            }
        });

        rdaActivityBinding.btnWeightDimensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectDimens = new Intent(RDAActivity.this, SelectDimensionActivity.class);
                startActivityForResult(selectDimens, 100);
            }
        });

        rdaActivityBinding.btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectWeight = new Intent(RDAActivity.this, SelectWeightActivity.class);
                startActivityForResult(selectWeight, 100);
            }
        });

        rdaActivityBinding.btnHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectHeight = new Intent(RDAActivity.this, SelectHeightActivity.class);
                startActivityForResult(selectHeight,100);
            }
        });

        rdaActivityBinding.btnGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalIntent = new Intent(RDAActivity.this, SelectGoalActivity.class);
                startActivityForResult(goalIntent, 100);
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

        String[] userRda = {data.getStringExtra("userAge"), data.getStringExtra("userGender"),
                            data.getStringExtra("userActivity"), data.getStringExtra("userDimensions"),
                            data.getStringExtra("userWeight"), data.getStringExtra("userHeight"),
                            data.getStringExtra("userGoal")};

        if(requestCode == 100 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserAge.setText(userRda[0]);
//            rdaActivityBinding.txtUserGender.setText(userRda[1]);
//            rdaActivityBinding.txtUserActivity.setText(userRda[2]);
//            rdaActivityBinding.txtUserWeightDimensions.setText(userRda[3]);
//            rdaActivityBinding.txtUserWeight.setText(userRda[4]);
//            rdaActivityBinding.txtUserHeight.setText(userRda[5]);
//            rdaActivityBinding.txtGoal.setText(userRda[6]);
        } else if(requestCode == 200 && resultCode == RESULT_OK && data != null) {
            rdaActivityBinding.txtUserGender.setText(userRda[1]);
        }
    }
}