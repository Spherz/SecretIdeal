package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityAddFoodBinding;

public class AddFoodActivity extends AppCompatActivity {

    private ActivityAddFoodBinding addFoodBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFoodBinding = ActivityAddFoodBinding.inflate(getLayoutInflater());
        setContentView(addFoodBinding.getRoot());

        addFoodBinding.txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}