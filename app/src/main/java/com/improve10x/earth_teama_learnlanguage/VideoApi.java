package com.improve10x.earth_teama_learnlanguage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoApi {

    public VideoService createVideoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideoService videoService = retrofit.create(VideoService.class);
        return videoService;
    }
}
