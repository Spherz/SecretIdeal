package com.example.fooddiary.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityDeleteUserBinding;

public class DeleteUserActivity extends AppCompatActivity {

    private ActivityDeleteUserBinding deleteUserBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deleteUserBinding = ActivityDeleteUserBinding.inflate(getLayoutInflater());
        setContentView(deleteUserBinding.getRoot());

        deleteUserBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Добавить удаление аккаунта пользователя
            }
        });

        deleteUserBinding.imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}