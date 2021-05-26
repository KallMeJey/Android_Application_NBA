package com.example.nba.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NbaApi {

    @GET("/api/v1/teams")
   fun getTeamList(): Call<NbaListResponse>;

    @GET("/api/v1/teams/{id}")
    fun getTeamDetail(@Path ("id")id:Int): Call<NbaDetailResponse>;
}