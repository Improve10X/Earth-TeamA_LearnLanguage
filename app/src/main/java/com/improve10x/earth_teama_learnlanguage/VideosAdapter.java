package com.improve10x.earth_teama_learnlanguage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

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
        holder.viewsTxt.setText(video.viewsTxt);
        holder.dotTxt.setText(video.dotTxt);
        holder.daysTxt.setText(video.daysTxt);
        Picasso.get().load(video.imageUrl).into(holder.videoImg);
        Picasso.get().load(video.iconImgUrl).into(holder.iconImg);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
