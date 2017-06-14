package com.example.mateusz.ready4s.data.remote;

import com.example.mateusz.ready4s.data.model.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mateusz on 2017-06-14.
 */

public interface SOService {

    @GET("")
    Call<Place> getAnswers();

    @GET("/geo")
    Call<List<Place>> getAnswers(@Query("lat") double lat, @Query("lng") double lng);
}
