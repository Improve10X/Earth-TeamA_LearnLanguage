package com.improve10x.earth_teama_learnlanguage.videos;

import android.os.Bundle;
import android.view.View;

import com.improve10x.earth_teama_learnlanguage.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideoActivity {
    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().hasExtra(Constants.KEY_VIDEOS)) {
            getSupportActionBar().setTitle("Edit Video");
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEOS);
            updateBtn.setVisibility(View.VISIBLE);
            addBtn.setVisibility(View.GONE);
            showData();
        }
        handleUpdateBtn();
    }

    private void handleUpdateBtn() {
        updateBtn.setOnClickListener(view -> {
            String title = titleTxt.getText().toString();
            String videoImgUrl = videoImgUrlTxt.getText().toString();
            String channelName = channelNameTxt.getText().toString();
            String channelLogo = channelLogoImageUrlTxt.getText().toString();
            String videoView = videoViewsTxt.getText().toString();
            String uploadedTime = uploadedTimeTxt.getText().toString();
            updateVideo(video.id, title, videoImgUrl, channelName, channelLogo, videoView, uploadedTime);
        });
    }

    private void updateVideo(String id, String title, String videoImgUrl, String channelName, String channelLogo, String videoView, String uploadedTime) {
        Video video = new Video();
        video.title = title;
        video.imageUrl = videoImgUrl;
        video.channelName = channelName;
        video.channelLogImgUrl = channelLogo;
        video.views = videoView;
        video.uploadedTime = uploadedTime;

        Call<Void> call = videosService.updateVideo(id, video);
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
        titleTxt.setText(video.title);
        videoImgUrlTxt.setText(video.imageUrl);
        channelNameTxt.setText(video.channelName);
        videoViewsTxt.setText(video.views);
        channelLogoImageUrlTxt.setText(video.channelLogImgUrl);
        uploadedTimeTxt.setText(video.uploadedTime);
    }
}
