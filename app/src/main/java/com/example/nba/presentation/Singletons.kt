package com.example.nba.presentation

import com.example.nba.presentation.api.NbaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singletons {
    companion object{
            val nbaApi: NbaApi = Retrofit.Builder()
                .baseUrl("https://www.balldontlie.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NbaApi::class.java)
    }
}


