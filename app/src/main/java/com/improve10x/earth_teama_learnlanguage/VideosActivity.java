package com.improve10x.earth_teama_learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

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
    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
        videosRv.setAdapter(videosAdapter);
    }
}