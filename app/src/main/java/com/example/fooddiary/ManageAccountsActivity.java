package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityManageAccountsBinding;

public class ManageAccountsActivity extends AppCompatActivity {

    private ActivityManageAccountsBinding manageAccountsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manageAccountsBinding = ActivityManageAccountsBinding.inflate(getLayoutInflater());
        setContentView(manageAccountsBinding.getRoot());

        manageAccountsBinding.imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        manageAccountsBinding.btnChangeUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeUsernameIntent = new Intent(ManageAccountsActivity.this, ChangeUsernmaeActivity.class);
                startActivity(changeUsernameIntent);
            }
        });

        manageAccountsBinding.btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteUserIntent = new Intent(ManageAccountsActivity.this, DeleteUserActivity.class);
                startActivity(deleteUserIntent);
            }
        });
    }
}