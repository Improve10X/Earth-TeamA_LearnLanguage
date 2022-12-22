package com.improve10x.earth_teama_learnlanguage.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.improve10x.earth_teama_learnlanguage.Constants;
import com.improve10x.earth_teama_learnlanguage.R;
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends AppCompatActivity {

    private  Video video;
    private ImageView videoImageUrl;
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
            getSupportActionBar().hide();
            video = (Video) intent.getSerializableExtra(Constants.KEY_VIDEOS);
            initViews();
            showData();
    }

    private void initViews() {
        videoImageUrl = findViewById(R.id.video_image_url_img);
        channelLogoImg = findViewById(R.id.channel_logo_url_img);
        titleTxt = findViewById(R.id.video_title_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadedTimeTxt = findViewById(R.id.uploded_time_text_txt);
    }

    private void showData() {
        if(video.imageUrl != null && video.imageUrl.isEmpty() == false) {
            Picasso.get().load(video.imageUrl).into(videoImageUrl);
        }
        if(video.channelLogImgUrl != null && video.channelLogImgUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogImgUrl).into(channelLogoImg);
        }
        titleTxt.setText(video.title);
        channelNameTxt.setText(video.channelName);
        viewsTxt.setText(video.views);
        uploadedTimeTxt.setText(video.uploadedTime);
    }
}