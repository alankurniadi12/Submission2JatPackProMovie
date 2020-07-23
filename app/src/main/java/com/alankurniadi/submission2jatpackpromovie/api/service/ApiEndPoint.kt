package com.alankurniadi.submission2jatpackpromovie.api.service

import com.alankurniadi.submission2jatpackpromovie.api.ResponsTrendingToday
import com.alankurniadi.submission2jatpackpromovie.api.Url
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("trending/all/day?api_key=${Url.API_KEY}")
    fun getTrendingToday() : Call<ResponsTrendingToday>
}