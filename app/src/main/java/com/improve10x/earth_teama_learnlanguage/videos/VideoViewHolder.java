package com.improve10x.earth_teama_learnlanguage.videos;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.earth_teama_learnlanguage.R;
import com.improve10x.earth_teama_learnlanguage.databinding.VideoItemBinding;

import org.w3c.dom.Text;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    VideoItemBinding binding;

    public VideoViewHolder(VideoItemBinding videoItemBinding) {
        super(videoItemBinding.getRoot());
        binding = videoItemBinding;
    }
}
