package com.improve10x.earth_teama_learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditActivity extends BaseActivity {
    private VideoService videoService;
    private EditText titleTxt;
    private EditText videoImgUrlTxt;
    private EditText channelNameTxt;
    private EditText channelLogoImageUrlTxt;
    private EditText videoViewsTxt;
    private EditText uploadedTimeTxt;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit);
        getSupportActionBar().setTitle("Add Video");
        initViews();
        setupApiService();
        handleAdd();
    }

    private void setupApiService() {
        VideoApi videoApi = new VideoApi();
        videoService = videoApi.createVideoService();

    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            String title = titleTxt.getText().toString();
            String videoImgUrl = videoImgUrlTxt.getText().toString();
            String channelName = channelNameTxt.getText().toString();
            String channelLogo = channelLogoImageUrlTxt.getText().toString();
            String videoView = videoViewsTxt.getText().toString();
            String uploadedTime = uploadedTimeTxt.getText().toString();
            Video video = createVideo(title, videoImgUrl, channelName, channelLogo, videoView, uploadedTime);
            saveVideo(video);
        });
    }

    private void saveVideo(Video video) {
            Call<Video> call = videoService.createVideo(video);
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

    private Video createVideo(String title, String videoImgUrl, String channelName, String channelLogo, String videoView, String uploadedTime) {
        Video video = new Video();
        video.title = title;
        video.imageUrl = videoImgUrl;
        video.channelName = channelName;
        video.channelLogImgUrl = channelLogo;
        video.views = videoView;
        video.uploadedTime = uploadedTime;
        return video;
    }

    private void initViews() {
        titleTxt = findViewById(R.id.title_txt);
        videoImgUrlTxt = findViewById(R.id.video_img_url_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        videoViewsTxt = findViewById(R.id.video_views_txt);
        channelLogoImageUrlTxt = findViewById(R.id.channel_name_txt);
        uploadedTimeTxt = findViewById(R.id.uploaded_time_txt);
        addBtn = findViewById(R.id.add_btn);
    }
}