package com.improve10x.earth_teama_learnlanguage;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected  void showToast(String message) {
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
    }
}
