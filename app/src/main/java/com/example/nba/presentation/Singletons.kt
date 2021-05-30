package com.example.nba.presentation

import com.example.nba.presentation.NbaApplication.Companion.context
import com.example.nba.presentation.api.NbaApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object {
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val nbaApi: NbaApi = Retrofit.Builder()
                .baseUrl("https://www.balldontlie.io")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()
                        .create(NbaApi::class.java)

    }
}


