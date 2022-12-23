package com.improve10x.earth_teama_learnlanguage.videos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.improve10x.earth_teama_learnlanguage.Constants;
import com.improve10x.earth_teama_learnlanguage.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideoActivity {

    private Video video;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        if (getIntent().hasExtra(Constants.KEY_VIDEOS)) {
            getSupportActionBar().setTitle("Edit Video");
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEOS);
            updateBtn.setVisibility(View.VISIBLE);
            showData();
        }
        handleUpdateBtn();
    }

    private void initViews() {
        updateBtn = findViewById(R.id.update_btn);
    }

    private void handleUpdateBtn() {
        updateBtn.setOnClickListener(view -> {
            String title = binding.titleTxt.getText().toString();
            String videoImgUrl = binding.videoImgUrlImg.getText().toString();
            String channelName = binding.channelNameTxt.getText().toString();
            String channelLogo = binding.channelLogoImageUrlImg.getText().toString();
            String videoView = binding.videoViewsTxt.getText().toString();
            String uploadedTime = binding.uploadedTimeTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
            Video updatedVideo = createVideo(title, videoImgUrl, channelName, channelLogo, videoView, uploadedTime, youtubeVideoId);
            updateVideo(video.id, updatedVideo);
        });
    }

    private void updateVideo(String id, Video updatedVideo) {
        Call<Void> call = videosService.updateVideo(id, updatedVideo);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully update video");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to update video");
            }
        });
    }

    private void showData() {
        binding.titleTxt.setText(video.title);
        binding.videoImgUrlImg.setText(video.imageUrl);
        binding.channelNameTxt.setText(video.channelName);
        binding.videoViewsTxt.setText(video.views);
        binding.channelLogoImageUrlImg.setText(video.channelLogImgUrl);
        binding.uploadedTimeTxt.setText(video.uploadedTime);
        binding.youtubeVideoIdTxt.setText(video.youtubePlayerId);
    }
}
