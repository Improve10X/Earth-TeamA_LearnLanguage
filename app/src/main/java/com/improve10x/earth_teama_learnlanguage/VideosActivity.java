package com.improve10x.earth_teama_learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

   private ArrayList<Video> videos ;
   private RecyclerView videosRv;
   private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        initViews();
        setupData();
        setupVideosAdapter();
        setupVideosRv();
    }

    private void setupData() {
        videos = new ArrayList<>();

        Video video1 = new Video();
        video1.imageUrl = "https://i.ytimg.com/vi/4xhfFP9ylsU/hqdefault.jpg?sqp=-oaymwEbCKgBEF5IVfKriqkDDggBFQAAiEIYAXABwAEG&rs=AOn4CLBBz8MEJGj8cjSX2iXv4zQ0QGnh5Q";
        video1.title = "Kung fu Panda";
        video1.iconImgUrl = "https://yt3.googleusercontent.com/ytc/AMLnZu_Qx8pZINayK8MHTCMpT2dH6xBNdGvwgFargUPF=s88-c-k-c0x00ffffff-no-rj";
        video1.viewsTxt = "300k views";
        video1.daysTxt = "10days ago";
        videos.add(video1);

        Video video2 = new Video();
        video2.imageUrl = "https://i.ytimg.com/an_webp/s5BMcaQsjbM/mqdefault_6s.webp?du=3000&sqp=CJOThp0G&rs=AOn4CLAjMfAaf4a-Bj93OojaxQGx7U_i0Q";
        video2.title = "Sam";
        video2.iconImgUrl = "https://yt3.ggpht.com/3ErdBd0bg2Qw5rKdqDK-7vPAf0tirRuodlGGZuhZePQcjEu8i5KniCN-EUCBtQkSOy14M26O=s68-c-k-c0x00ffffff-no-rj";
        video2.viewsTxt = "300k views";
        video2.daysTxt = "10days ago";
        videos.add(video2);
    }

    private void initViews() {
        videosRv = findViewById(R.id.videos_rv);
    }

    private void setupVideosAdapter() {
        videosAdapter = new VideosAdapter();
        videosAdapter.setData(videos);
    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
        videosRv.setAdapter(videosAdapter);
    }
}