package com.improve10x.earth_teama_learnlanguage.api;

import com.improve10x.earth_teama_learnlanguage.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideosApi {

    public VideosService createVideoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideosService videosService = retrofit.create(VideosService.class);
        return videosService;
    }
}
