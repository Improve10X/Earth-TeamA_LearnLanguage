package com.improve10x.earth_teama_learnlanguage.videos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.improve10x.earth_teama_learnlanguage.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVideoActivity extends BaseAddEditVideoActivity {

    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Video");
        initViews();
        addBtn.setVisibility(View.VISIBLE);
        handleAdd();
    }

    private void initViews() {
        addBtn = findViewById(R.id.add_btn);
    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            String title = binding.titleTxt.getText().toString();
            String videoImgUrl = binding.videoImgUrlImg.getText().toString();
            String channelName = binding.channelNameTxt.getText().toString();
            String channelLogo = binding.channelLogoImageUrlImg.getText().toString();
            String videoView = binding.videoViewsTxt.getText().toString();
            String uploadedTime = binding.uploadedTimeTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
            Video video = createVideo(title, videoImgUrl, channelName, channelLogo, videoView, uploadedTime, youtubeVideoId);
            addVideo(video);
        });
    }

    private void addVideo(Video video) {
        Call<Video> call = videosService.createVideo(video);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                showToast("Successfully created video");
                finish();
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                showToast("Failed to save video");
            }
        });
    }
}
