package com.alankurniadi.submission2jatpackpromovie.api

import com.alankurniadi.submission2jatpackpromovie.api.service.ApiEndPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private fun getInitTrendingToday(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getInitInstance(): ApiEndPoint {
        return getInitTrendingToday().create(ApiEndPoint::class.java)
    }
}

