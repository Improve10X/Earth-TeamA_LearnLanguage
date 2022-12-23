package com.improve10x.earth_teama_learnlanguage.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.improve10x.earth_teama_learnlanguage.Constants;
import com.improve10x.earth_teama_learnlanguage.R;
import com.improve10x.earth_teama_learnlanguage.databinding.ActivityPlayVideoBinding;
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private ActivityPlayVideoBinding binding;
    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        video = (Video) intent.getSerializableExtra(Constants.KEY_VIDEOS);
        showData();
        setupYouTubeVideoPlayer();
    }

    private void setupYouTubeVideoPlayer() {
        binding.youtubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(video.youtubePlayerId);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(PlayVideoActivity.this, "Failed to initialized youtube player", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showData() {
        if (video.channelLogImgUrl != null && video.channelLogImgUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogImgUrl).into(binding.channelLogoUrlImg);
        }
        binding.videoTitleTxt.setText(video.title);
        binding.channelNameTxt.setText(video.channelName);
        binding.viewsTxt.setText(video.views);
        binding.uplodedTimeTextTxt.setText(video.uploadedTime);
    }
}