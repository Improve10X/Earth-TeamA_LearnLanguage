package com.improve10x.earth_teama_learnlanguage.videos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.improve10x.earth_teama_learnlanguage.R;
import com.improve10x.earth_teama_learnlanguage.base.BaseActivity;

public class BaseAddEditVideoActivity extends BaseActivity {

    protected EditText titleTxt;
    protected EditText videoImgUrlTxt;
    protected EditText channelNameTxt;
    protected EditText channelLogoImageUrlTxt;
    protected EditText videoViewsTxt;
    protected EditText uploadedTimeTxt;
    protected Button addBtn;
    protected Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit);
        initViews();
    }

    private void initViews() {
        titleTxt = findViewById(R.id.title_txt);
        videoImgUrlTxt = findViewById(R.id.video_img_url_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        videoViewsTxt = findViewById(R.id.video_views_txt);
        channelLogoImageUrlTxt = findViewById(R.id.channel_logo_image_url_txt);
        uploadedTimeTxt = findViewById(R.id.uploaded_time_txt);
        addBtn = findViewById(R.id.add_btn);
        updateBtn = findViewById(R.id.update_btn);
    }
}