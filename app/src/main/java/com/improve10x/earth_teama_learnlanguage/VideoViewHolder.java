package com.improve10x.earth_teama_learnlanguage;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    ImageView videoImg;
    TextView videoTitleTxt;
    ImageView channelLogImg;
    TextView channelNameTxt;
    TextView viewsTxt;
    TextView uploadedTimeTxt;
    ImageButton deleteImgBtn;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoImg = itemView.findViewById(R.id.video_img);
        videoTitleTxt = itemView.findViewById(R.id.video_title_txt);
        channelLogImg = itemView.findViewById(R.id.channel_logo_img);
        channelNameTxt = itemView.findViewById(R.id.channel_name_txt);
        viewsTxt = itemView.findViewById(R.id.views_txt);
        uploadedTimeTxt = itemView.findViewById(R.id.uploaded_time_txt);
        deleteImgBtn = itemView.findViewById(R.id.delete_img_btn);
    }
}
