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
        video1.imageUrl = "https://i.ytimg.com/an_webp/4BgWg2EAmww/mqdefault_6s.webp?du=3000&sqp=COS8h50G&rs=AOn4CLBvyrsN1bY5xuvUMhtXNXf3YJ5s5Q";
        video1.title = "Abdul Kalam, A Lesson for my Teacher: Learn English (IND) - Story for Children";
        video1.channelLogImgUrl = "https://yt3.ggpht.com/ytc/AMLnZu-VKA65djvd53kKMls4yvfdkkrVQgBZfTF5BNFqgA=s68-c-k-c0x00ffffff-no-rj";
        video1.channelName = "BookBox.com";
        video1.views = "3.3M views";
        video1.uploadedTime = "11years ago";
        videos.add(video1);

        Video video2 = new Video();
        video2.imageUrl = "https://i.ytimg.com/an_webp/XbhecuoEgxs/mqdefault_6s.webp?du=3000&sqp=CNPah50G&rs=AOn4CLCb41nrALCfFBQnFD7Rgyhf0-m_2A";
        video2.title = "Kung Fu Panda | Who Are You";
        video2.channelLogImgUrl = "https://yt3.ggpht.com/ytc/AMLnZu_Qx8pZINayK8MHTCMpT2dH6xBNdGvwgFargUPF=s48-c-k-c0x00ffffff-no-rj";
        video2.channelName = "Khaled Osman";
        video2.views = "38.5k views";
        video2.uploadedTime = "1year ago";
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