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
        if(getIntent().hasExtra(Constants.KEY_VIDEOS)) {
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
            String title = titleTxt.getText().toString();
            String videoImgUrl = videoImgUrlImg.getText().toString();
            String channelName = channelNameTxt.getText().toString();
            String channelLogo = channelLogoImageUrlImg.getText().toString();
            String videoView = videoViewsTxt.getText().toString();
            String uploadedTime = uploadedTimeTxt.getText().toString();
            Video updatedVideo = createVideo(title, videoImgUrl, channelName, channelLogo, videoView, uploadedTime);
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
        titleTxt.setText(video.title);
        videoImgUrlImg.setText(video.imageUrl);
        channelNameTxt.setText(video.channelName);
        videoViewsTxt.setText(video.views);
        channelLogoImageUrlImg.setText(video.channelLogImgUrl);
        uploadedTimeTxt.setText(video.uploadedTime);
    }
}
