package com.alankurniadi.submission2jatpackpromovie.api.service

import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.DetailMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    // Home
    @GET("trending/all/week?api_key=${Url.API_KEY}")
    fun getTrendingWeek() : Call<TrendingWeek.ResponsWeek>

    @GET("movie/now_playing?api_key=${Url.API_KEY}")
    fun getNowPlayingMovie() : Call<NowPlayingMovie.ResponseNowPlaying>

    @GET("tv/airing_today?api_key=${Url.API_KEY}")
    fun getNowAiringTv(): Call<NowAiringTv.ResponseAiringTv>

    // Detail
    @GET("movie/{movie_id}?api_key=${Url.API_KEY}")
    fun getDetailMovie(@Path("movie_id") id: Int?): Call<DetailMovie>
}