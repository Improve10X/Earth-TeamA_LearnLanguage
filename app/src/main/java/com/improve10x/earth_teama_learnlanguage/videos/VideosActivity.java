package com.improve10x.earth_teama_learnlanguage.videos;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.improve10x.earth_teama_learnlanguage.Constants;
import com.improve10x.earth_teama_learnlanguage.R;
import com.improve10x.earth_teama_learnlanguage.api.VideosService;
import com.improve10x.earth_teama_learnlanguage.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosActivity extends BaseActivity {

   private ArrayList<Video> videos = new ArrayList<>();
   private RecyclerView videosRv;
   private VideosAdapter videosAdapter;;
   private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        initViews();
        setupVideosRv();
        setupVideosAdapter();
        handleAddBtn();
    }

    private void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddVideoActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchVideos();
    }

    private void fetchVideos() {
        Call<List<Video>> call = videosService.fetchVideos();
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
                Intent intent = new Intent(VideosActivity.this, PlayVideoActivity.class);
                intent.putExtra(Constants.KEY_VIDEOS, video);
                startActivity(intent);
            }

            @Override
            public void onItemDelete(Video video) {
                deleteVideo(video);
                fetchVideos();
            }

            @Override
            public void onItemEdit(Video video) {
                Intent intent = new Intent(VideosActivity.this, EditVideoActivity.class);
                intent.putExtra(Constants.KEY_VIDEOS, video);
                startActivity(intent);
            }
        });
        videosRv.setAdapter(videosAdapter);
    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void deleteVideo(Video video) {
        Call<Void> call = videosService.deleteVideo(video.id);
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