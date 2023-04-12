package com.example.fooddiary.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fooddiary.R;
import com.example.fooddiary.databinding.ActivityProfileBinding;
import com.example.fooddiary.util.DBManager;
import com.google.android.material.navigation.NavigationBarView;

// TODO: Это активити переделать в фрагмент

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding profileBinding;

    private final int GALLERY_REQ_CODE = 1000;

    DBManager dbManager;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            profileBinding.userImg.setImageURI(data.getData());
        } else {
            Toast.makeText(this, "Вы не выбрали изображение", Toast.LENGTH_SHORT).show();
        }
    }

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
                weightIntent.putExtra("loginStr", username);
                startActivity(weightIntent);
            }
        });

        insertFoodData();

        profileBinding.userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(photoPickerIntent, GALLERY_REQ_CODE);
            }
        });

        profileBinding.bottomNav.setSelectedItemId(R.id.item1);

        profileBinding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        return true;
                    case R.id.item2:
                        Intent diaryIntent = new Intent(ProfileActivity.this, DiaryActivity.class);
                        diaryIntent.putExtra("username", username);
                        startActivityForResult(diaryIntent, 200);
                        return true;
                    case R.id.item3:
                        Intent settingsIntent = new Intent(ProfileActivity.this, SettingsActivity.class);
                        settingsIntent.putExtra("username", username);
                        startActivity(settingsIntent);
                        return true;
                }
                return false;
            }
        });
    }

    public void insertFoodData() {
        dbManager = new DBManager(this);
        dbManager.open();
        dbManager.insertFood("test", "1234", "567", "789", "566");
        dbManager.insertFood("Белый Рис", "129", "0,28г", "27,9г", "2,66г");
        dbManager.insertFood("Лапша", "219", "3,3г", "40,02г", "7,22г");
        dbManager.insertFood("Спагетти", "157", "0,92г", "30,68г", "5,76г");
        dbManager.insertFood("Макароны или Лапша с Сыром", "493", "22,84г", "52,15г", "19,29г");

        dbManager.insertFood("Жареная Баранина", "266", "18,15г", "0г", "23,93г");
        dbManager.insertFood("Бекон", "541", "41,78г", "1,43г", "37,04г");
        dbManager.insertFood("Бекон (Жареный)", "533", "40,3г", "1,5г", "38,34г");
        dbManager.insertFood("Говяжий Фарш", "276", "18,58г", "0г", "25,35г");
        dbManager.insertFood("Говядина", "288", "19,54г", "0г", "26,33г");
        dbManager.insertFood("Жареная Курица", "147", "8,36г", "0г", "16,79г");

        dbManager.insertFood("Ванильный Йогурт (Обезжиренный)", "85", "1,25г", "13,8г", "4,93г");
        dbManager.insertFood("Молоко", "122", "4,88г", "11,49г", "8,03г");
        dbManager.insertFood("Молоко (с Низким Содержанием Жира)", "102", "2,37г", "12,18г", "8,22г");
        dbManager.insertFood("Творог с Фруктами", "97", "3,85г", "4,61г", "10,69г");

        dbManager.insertFood("Вода", "0", "0г", "0г", "0г");
        dbManager.insertFood("Кофе Латте", "135", "5,51г", "12,36г", "8,81г");
        dbManager.insertFood("Кофе Эспрессо", "1", "0,11г", "0г", "0,07г");
        dbManager.insertFood("Растворимый Кофе (из Порошка)", "5", "0г", "0,9г", "0,26г");
        dbManager.insertFood("Чай", "2", "0г", "0,71г", "0г");
        dbManager.insertFood("Чай Несладкий", "2", "0г", "0,76г", "0,02г");
        dbManager.insertFood("Травяной Чай", "2", "0г", "0,47г", "0г");
        dbManager.insertFood("Зеленый Чай", "2", "0г", "0,47г", "0г");
        dbManager.insertFood("Чай с Сахаром", "47", "0г", "12,51г", "0,02г");
    }

}