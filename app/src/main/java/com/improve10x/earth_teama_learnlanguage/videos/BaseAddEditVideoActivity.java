package com.improve10x.earth_teama_learnlanguage.videos;

import android.os.Bundle;
import android.widget.EditText;

import com.improve10x.earth_teama_learnlanguage.R;
import com.improve10x.earth_teama_learnlanguage.base.BaseActivity;
import com.improve10x.earth_teama_learnlanguage.databinding.ActivityBaseAddEditBinding;

public class BaseAddEditVideoActivity extends BaseActivity {

    protected ActivityBaseAddEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseAddEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    protected Video createVideo(String title, String videoImgUrl, String channelName, String channelLogo, String videoView, String uploadedTime, String youtubeVideoId) {
        Video video = new Video();
        video.title = title;
        video.imageUrl = videoImgUrl;
        video.channelName = channelName;
        video.channelLogImgUrl = channelLogo;
        video.views = videoView;
        video.uploadedTime = uploadedTime;
        video.youtubePlayerId = youtubeVideoId;
        return video;
    }

}