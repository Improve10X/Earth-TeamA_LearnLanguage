package com.improve10x.earth_teama_learnlanguage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

    public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

     OnItemActionListener onItemActionListener;

    public void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

    private List<Video> videos;
    void setData(List<Video> videoList){
        videos = videoList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        holder.videoTitleTxt.setText(video.title);
        holder.channelNameTxt.setText(video.channelName);
        holder.viewsTxt.setText(video.views);
        holder.uploadedTimeTxt.setText(video.uploadedTime);
        if(video.imageUrl != null && video.imageUrl.isEmpty() == false) {
            Picasso.get().load(video.imageUrl).into(holder.videoImg);
        }
        if(video.channelLogImgUrl != null && video.channelLogImgUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogImgUrl).into(holder.channelLogImg);
        }
        holder.deleteImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(video);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClick(video);
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
