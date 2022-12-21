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
            String title = titleTxt.getText().toString();
            String videoImgUrl = videoImgUrlTxt.getText().toString();
            String channelName = channelNameTxt.getText().toString();
            String channelLogo = channelLogoImageUrlTxt.getText().toString();
            String videoView = videoViewsTxt.getText().toString();
            String uploadedTime = uploadedTimeTxt.getText().toString();
            Video video = addVideo(title, videoImgUrl, channelName, channelLogo, videoView, uploadedTime);
            saveVideo(video);
        });
    }

    private Video addVideo(String title, String videoImgUrl, String channelName, String channelLogo, String videoView, String uploadedTime) {
        Video video = new Video();
        video.title = title;
        video.imageUrl = videoImgUrl;
        video.channelName = channelName;
        video.channelLogImgUrl = channelLogo;
        video.views = videoView;
        video.uploadedTime = uploadedTime;
        return video;
    }

    private void saveVideo(Video video) {
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
