package com.improve10x.earth_teama_learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VideoService {

@GET("EarthTeamAVideos")
    Call<List<Video>> fetchVideos();
}
