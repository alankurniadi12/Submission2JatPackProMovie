package com.alankurniadi.submission2jatpackpromovie.api.service

import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {

    // Home
    @GET("trending/all/week?api_key=${Url.API_KEY}")
    fun getTrendingWeek() : Call<TrendingWeek.ResponsWeek>

    @GET("movie/now_playing?api_key=${Url.API_KEY}")
    fun getNowPlayingMovie() : Call<NowPlayingMovie.ResponseNowPlaying>

    @GET("tv/airing_today?api_key=${Url.API_KEY}")
    fun getNowAiringTv(): Call<NowAiringTv.ResponseAiringTv>

    // Detail from trending week
    @GET("movie/{id}?api_key=${Url.API_KEY}")
    fun getDetailTrending(

    )

    // Detail Movie
    @GET("movie/{movie_id}?api_key=${Url.API_KEY}")
    fun getDetailMovie(
        @Path("movie_id") id: Int?
    ): Call<Detail.Movie>

    // Detail Tv
    @GET("tv/{id}?api_key=${Url.API_KEY}")
    fun getDetailTv(
        @Path("id") id: Int?
    ): Call<Detail.TvShow>
}