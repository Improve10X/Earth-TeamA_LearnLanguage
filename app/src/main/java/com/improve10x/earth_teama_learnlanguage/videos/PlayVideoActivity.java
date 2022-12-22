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
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private  Video video;
    private YouTubePlayerView youTubePlayerView;
    private ImageView channelLogoImg;
    private TextView titleTxt;
    private TextView channelNameTxt;
    private TextView viewsTxt;
    private  TextView uploadedTimeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Intent intent = getIntent();
            video = (Video) intent.getSerializableExtra(Constants.KEY_VIDEOS);
            initViews();
            showData();
            setupYouTubeVideoPlayer();
    }

    private void setupYouTubeVideoPlayer() {
        youTubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
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

    private void initViews() {
        channelLogoImg = findViewById(R.id.channel_logo_url_img);
        titleTxt = findViewById(R.id.video_title_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadedTimeTxt = findViewById(R.id.uploded_time_text_txt);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
    }

    private void showData() {
        if(video.channelLogImgUrl != null && video.channelLogImgUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogImgUrl).into(channelLogoImg);
        }
        titleTxt.setText(video.title);
        channelNameTxt.setText(video.channelName);
        viewsTxt.setText(video.views);
        uploadedTimeTxt.setText(video.uploadedTime);
    }
}