package com.improve10x.earth_teama_learnlanguage.videos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.earth_teama_learnlanguage.R;
import com.improve10x.earth_teama_learnlanguage.databinding.VideoItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> videos;
    private OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener actionListener) {
        onItemActionListener = actionListener;
    }

    void setData(List<Video> videoList) {
        videos = videoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VideoItemBinding binding = VideoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(binding);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        holder.binding.videoTitleTxt.setText(video.title);
        holder.binding.channelNameTxt.setText(video.channelName);
        holder.binding.viewsTxt.setText(video.views);
        holder.binding.uploadedTimeTxt.setText(video.uploadedTime);
        if (video.imageUrl != null && video.imageUrl.isEmpty() == false) {
            Picasso.get().load(video.imageUrl).into(holder.binding.videoImg);
        }
        if (video.channelLogImgUrl != null && video.channelLogImgUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogImgUrl).into(holder.binding.channelLogoImg);
        }
        holder.binding.deleteImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(video);
        });
        holder.binding.getRoot().setOnClickListener(view -> {
            onItemActionListener.onItemClick(video);
        });
        holder.binding.editImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemEdit(video);
        });
    }

    @Override
    public int getItemCount() {

        return videos.size();
    }
}
