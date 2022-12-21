package com.improve10x.earth_teama_learnlanguage;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosActivity extends BaseActivity {

   private ArrayList<Video> videos = new ArrayList<>();
   private RecyclerView videosRv;
   private VideosAdapter videosAdapter;
   private VideoService videoService;
   private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        initViews();
        //setupData();
        setupVideosAdapter();
        setupVideosRv();
        setupApiService();
        handleAddBtn();
    }

    private void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, BaseAddEditActivity.class);
            startActivity(intent);
        });
    }

    private void setupApiService() {
        VideoApi videoApi = new VideoApi();
        videoService = videoApi.createVideoService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchVideos();
    }

    private void fetchVideos() {
        Call<List<Video>> call = videoService.fetchVideos();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                List<Video> videos = response.body();
                videosAdapter.setData(videos);
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                showToast("Failed to fetch video");
            }
        });
    }

    //private void setupData() {
    //}

    private void initViews() {
        videosRv = findViewById(R.id.videos_rv);
        addBtn = findViewById(R.id.add_btn);
    }

    private void setupVideosAdapter() {
        videosAdapter = new VideosAdapter();
        videosAdapter.setData(videos);
        videosAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClick(Video video) {
                showToast("Item Clicked");
            }

            @Override
            public void onItemDelete(Video video) {
                deleteVideo(video);
                fetchVideos();
            }

            @Override
            public void onItemEdit(Video video) {
                showToast("Item Edit");
            }
        });
    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
        videosRv.setAdapter(videosAdapter);
    }

    private void deleteVideo(Video video) {
        Call<Void> call = videoService.deleteVideo(video.id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("successfully deleted video");
                fetchVideos();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to delete the video");
            }
        });

    }
}