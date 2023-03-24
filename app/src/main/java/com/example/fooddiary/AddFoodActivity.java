package com.example.fooddiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.databinding.ActivityAddFoodBinding;

import java.util.ArrayList;

public class AddFoodActivity extends AppCompatActivity {

    private ActivityAddFoodBinding addFoodBinding;
    ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFoodBinding = ActivityAddFoodBinding.inflate(getLayoutInflater());
        setContentView(addFoodBinding.getRoot());

        init();

        AddFoodAdapter adapter = new AddFoodAdapter(this, foodItems);

        addFoodBinding.rcList.setAdapter(adapter);

        addFoodBinding.txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void init() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        addFoodBinding.rcList.setLayoutManager(manager);

        foodItems.add(new FoodItem(100, 209, 300));
        foodItems.add(new FoodItem(150, 219, 400));
        foodItems.add(new FoodItem(200, 229, 500));
        foodItems.add(new FoodItem(250, 239, 600));
        foodItems.add(new FoodItem(3000, 249, 700));

    }
}