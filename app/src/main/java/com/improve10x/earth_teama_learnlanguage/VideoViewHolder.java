package com.improve10x.earth_teama_learnlanguage;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    ImageView videoImg;
    TextView videoTitleTxt;
    ImageView iconImg;
    TextView viewsTxt;
    TextView dotTxt;
    TextView daysTxt;
    ImageButton deleteImgBtn;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoImg = itemView.findViewById(R.id.video_img);
        videoTitleTxt = itemView.findViewById(R.id.video_title_txt);
        iconImg = itemView.findViewById(R.id.icon_img);
        viewsTxt = itemView.findViewById(R.id.views_txt);
        dotTxt = itemView.findViewById(R.id.dot_txt);
        daysTxt = itemView.findViewById(R.id.days_txt);
        deleteImgBtn = itemView.findViewById(R.id.delete_img_btn);
    }
}
