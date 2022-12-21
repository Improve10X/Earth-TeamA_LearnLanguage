package com.improve10x.earth_teama_learnlanguage.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.improve10x.earth_teama_learnlanguage.api.VideosApi;
import com.improve10x.earth_teama_learnlanguage.api.VideosService;

public class BaseActivity extends AppCompatActivity {

    protected VideosService videosService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupApiService();
    }

    protected  void showToast(String message) {
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
    }

    private void setupApiService() {
        VideosApi videosApi = new VideosApi();
        videosService = videosApi.createVideoService();
    }
}
