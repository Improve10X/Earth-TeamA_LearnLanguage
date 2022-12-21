package com.improve10x.earth_teama_learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VideoService {

    @GET(Constants.VIDEOS_END_POINT)
    Call<List<Video>> fetchVideos();

    @POST(Constants.VIDEOS_END_POINT)
    Call<Video> createVideo(@Body Video video);

    @DELETE(Constants.VIDEOS_END_POINT + "/{id}")
    Call<Void> deleteVideo(@Path("id") String id);
}
