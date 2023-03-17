package com.example.fooddiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fooddiary.databinding.ActivityProfileBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.io.FileNotFoundException;
import java.io.InputStream;

// TODO: Это активити переделать в фрагмент

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding profileBinding;

    private final int GALLERY_REQ_CODE = 1000;

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
                startActivity(weightIntent);
            }
        });

        profileBinding.userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(photoPickerIntent, GALLERY_REQ_CODE);
            }
        });

        profileBinding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item2:
                        Intent diaryIntent = new Intent(ProfileActivity.this, DiaryActivity.class);
                        startActivity(diaryIntent);
                        return true;
                }
                return false;
            }
        });


    }
}