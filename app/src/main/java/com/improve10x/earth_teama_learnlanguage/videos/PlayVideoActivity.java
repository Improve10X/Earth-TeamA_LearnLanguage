package com.improve10x.earth_teama_learnlanguage.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.earth_teama_learnlanguage.R;

public class PlayVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        getSupportActionBar().setTitle("Play Video");
    }
}