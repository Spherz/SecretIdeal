package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityProfileBinding;

// TODO: Это активити переделать в фрагмент

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding profileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(profileBinding.getRoot());

        Intent intent = getIntent();
        String username = intent.getStringExtra("loginStr");

        profileBinding.txtUsername.setText(username);

        profileBinding.btnUserWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weightIntent = new Intent(ProfileActivity.this, UserWeightActivity.class);
                startActivity(weightIntent);
            }
        });
    }
}