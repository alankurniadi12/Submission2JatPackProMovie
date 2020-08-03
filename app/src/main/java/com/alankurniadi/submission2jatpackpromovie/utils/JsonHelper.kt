package com.alankurniadi.submission2jatpackpromovie.utils

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JsonHelper(private val context: Context) {

    fun loadTrendingWeek(): MutableLiveData<List<TrendingWeek.DataWeek>>{
        val list = MutableLiveData <List<TrendingWeek.DataWeek>>()
        val call = RetrofitConfig().getInitInstance()
        call.getTrendingWeek().enqueue(object : Callback<TrendingWeek.ResponsWeek> {
            override fun onFailure(call: Call<TrendingWeek.ResponsWeek>, t: Throwable) {
                Log.e("WeekViewModel", t.toString())
            }

            override fun onResponse(
                call: Call<TrendingWeek.ResponsWeek>,
                response: Response<TrendingWeek.ResponsWeek>
            ) {
                Log.e("WeekViewModel", response.toString())
                val body = response.body()?.results
                list.postValue(body)
            }
        })
        return list
    }

    fun loadNowPlayingMovie(): MutableLiveData<List<NowPlayingMovie.Results>> {
        val list = MutableLiveData<List<NowPlayingMovie.Results>> ()
        val call = RetrofitConfig().getInitInstance()
        call.getNowPlayingMovie().enqueue(object : Callback<NowPlayingMovie.ResponseNowPlaying> {
            override fun onFailure(call: Call<NowPlayingMovie.ResponseNowPlaying>, t: Throwable) {
                Log.e("MovieListViewModel", t.toString())
            }
            override fun onResponse(
                call: Call<NowPlayingMovie.ResponseNowPlaying>,
                response: Response<NowPlayingMovie.ResponseNowPlaying>
            ) {
                Log.e("MovieListViewModel", response.message())
                val body = response.body()?.results
                list.postValue(body)
            }
        })
        return list
    }

    fun loadTvShow(): MutableLiveData<List<NowAiringTv.Results>> {
        val list = MutableLiveData<List<NowAiringTv.Results>>()
        val call = RetrofitConfig().getInitInstance()
        call.getNowAiringTv().enqueue(object : Callback<NowAiringTv.ResponseAiringTv> {
            override fun onFailure(call: Call<NowAiringTv.ResponseAiringTv>, t: Throwable) {
                Log.e("TvViewModel", t.toString())
            }

            override fun onResponse(
                call: Call<NowAiringTv.ResponseAiringTv>,
                response: Response<NowAiringTv.ResponseAiringTv>
            ) {
                Log.e("TvViewModel", response.toString())
                val body = response.body()?.results
                list.postValue(body)
            }
        })
        return list
    }


}
