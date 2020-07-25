package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel: ViewModel() {

    val list = MutableLiveData<List<NowPlayingMovie.Results>>()

    fun setNowPlayingMovie() {
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
    }

    fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>>{
        return list
    }
}