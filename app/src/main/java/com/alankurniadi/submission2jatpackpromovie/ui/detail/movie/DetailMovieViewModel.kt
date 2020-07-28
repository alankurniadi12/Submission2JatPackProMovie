package com.alankurniadi.submission2jatpackpromovie.ui.detail.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieViewModel: ViewModel() {

    val data = MutableLiveData<Detail.Movie>()

    fun setDetailMovie(id: Int?) {
        val call = RetrofitConfig().getInitInstance()
        call.getDetailMovie(id).enqueue(object : Callback<Detail.Movie>{
            override fun onFailure(call: Call<Detail.Movie>, t: Throwable) {
                Log.e("DetailMovieViewModel", t.toString())
            }
            override fun onResponse(call: Call<Detail.Movie>, response: Response<Detail.Movie>) {
                val body = response.body()
                Log.e("DetailMovieViewModel", body.toString())
                data.postValue(body)
            }
        })
    }
    fun getDetailMovie(): LiveData<Detail.Movie> {
        return data
    }
}