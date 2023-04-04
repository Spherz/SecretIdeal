package com.example.fooddiary.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityUserWeightBinding;
import com.example.fooddiary.util.DBManager;

// TODO: Сделать фрагментом
public class UserWeightActivity extends AppCompatActivity {

    private ActivityUserWeightBinding userWeightBinding;

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userWeightBinding = ActivityUserWeightBinding.inflate(getLayoutInflater());
        setContentView(userWeightBinding.getRoot());

        Intent intent = getIntent();
        String username = intent.getStringExtra("loginStr");

//        dbManager = new DBManager(this);
//        dbManager.open();

        userWeightBinding.imgAddUserWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addUserWeightIntent = new Intent(UserWeightActivity.this, AddUserWeightActivity.class);
                addUserWeightIntent.putExtra("username", username);
                startActivityForResult(intent, 100);
            }
        });

        userWeightBinding.imgBack.setOnClickListener(new View.OnClickListener() {
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
            userWeightBinding.txtWeight.setText(data.getStringExtra("editedWeight"));
        }
    }
}