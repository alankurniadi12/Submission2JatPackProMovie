package com.alankurniadi.submission2jatpackpromovie.api

import com.alankurniadi.submission2jatpackpromovie.api.service.ApiEndPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private fun getInitTrending(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getInitInstance(): ApiEndPoint {
        return getInitTrending().create(ApiEndPoint::class.java)
    }
}

