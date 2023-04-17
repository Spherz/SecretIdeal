package com.example.fooddiary.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fooddiary.R;
import com.example.fooddiary.adapter.DiaryAdapter;
import com.example.fooddiary.adapter.UserWeightAdapter;
import com.example.fooddiary.databinding.ActivityUserWeightBinding;
import com.example.fooddiary.model.ButtonItem;
import com.example.fooddiary.util.DBManager;

import java.util.ArrayList;

// TODO: Сделать фрагментом
public class UserWeightActivity extends AppCompatActivity {

    private ActivityUserWeightBinding userWeightBinding;

    UserWeightAdapter adapter;

    ArrayList<String> year = new ArrayList<String>();

    ArrayList<String> years = new ArrayList<String>();
    ArrayList<String> date = new ArrayList<String>();
    ArrayList<String> weight = new ArrayList<String>();

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userWeightBinding = ActivityUserWeightBinding.inflate(getLayoutInflater());
        setContentView(userWeightBinding.getRoot());

        initRecyclerView();

        Intent intent = getIntent();
        String username = intent.getStringExtra("loginStr");

        dbManager = new DBManager(this);
        dbManager.open();

//        System.out.println(dbManager.findByWeight(username));
//        System.out.println(username);

        if(dbManager.findByWeight(username) != null) {
            userWeightBinding.txtWeight.setText(dbManager.findByWeight(username));
        }

        userWeightBinding.imgAddUserWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addUserWeightIntent = new Intent(UserWeightActivity.this, AddUserWeightActivity.class);
                addUserWeightIntent.putExtra("username", username);
                addUserWeightIntent.putExtra("weight", userWeightBinding.txtWeight.getText().toString());
                startActivityForResult(addUserWeightIntent, 100);
            }
        });

        userWeightBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        // TODO Переделать при добавлении веса

        year.add("2020");
        year.add("2020");
        year.add("2020");
        year.add("2020");
        year.add("2021");
        year.add("2021");
        year.add("2021");
        year.add("2021");
        year.add("2022");
        year.add("2022");
        year.add("2022");
        year.add("2022");
        year.add("2023");
        year.add("2023");
        year.add("2023");
        year.add("2019");
        year.add("2019");
        year.add("2019");
        year.add("2019");
        year.add("2018");
        year.add("2017");
        year.add("2017");
        year.add("2017");
        year.add("2016");
        year.add("2016");
        year.add("2016");
        year.add("2016");
        year.add("2015");
        year.add("2015");
        year.add("2015");
        year.add("2014");

        date.add("15 August");
        date.add("1 July");
        date.add("5 September");
        date.add("30 March");
        date.add("2 January");
        date.add("27 October");
        date.add("13 March");
        date.add("20 February");
        date.add("7 April");
        date.add("8 April");

        weight.add("50.2");
        weight.add("50.3");
        weight.add("50.7");
        weight.add("50.8");
        weight.add("53.4");
        weight.add("57.2");
        weight.add("59.2");
        weight.add("60.2");
        weight.add("61.2");
        weight.add("63.2");

        for (String yeas : year) {
            if (years.contains(yeas)) {
                years.add("");
            } else {
                years.add(yeas);
            }
        }

        System.out.println(String.valueOf(years));

        adapter = new UserWeightAdapter(this, years, date, weight);

        userWeightBinding.rcWeightByDate.setHasFixedSize(true);

        userWeightBinding.rcWeightByDate.setAdapter(adapter);
        userWeightBinding.rcWeightByDate.setLayoutManager(manager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK && data != null) {
            userWeightBinding.txtWeight.setText(data.getStringExtra("editedWeight"));
        }
    }
}