package com.alankurniadi.submission2jatpackpromovie.api.service

import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("trending/all/week?api_key=${Url.API_KEY}")
    fun getTrendingWeek() : Call<TrendingWeek.ResponsWeek>

}