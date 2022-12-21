package com.improve10x.earth_teama_learnlanguage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoApi {

    public VideoService createVideoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideoService videoService = retrofit.create(VideoService.class);
        return videoService;
    }
}
