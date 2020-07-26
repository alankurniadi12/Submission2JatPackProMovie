package com.alankurniadi.submission2jatpackpromovie.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.DetailMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieViewModel: ViewModel() {

    val data = MutableLiveData<DetailMovie>()

    fun setDetailMovie(id: Int?) {
        val call = RetrofitConfig().getInitInstance()
        call.getDetailMovie(id).enqueue(object : Callback<DetailMovie>{
            override fun onFailure(call: Call<DetailMovie>, t: Throwable) {
                Log.e("DetailMovieViewModel", t.toString())
            }
            override fun onResponse(call: Call<DetailMovie>, response: Response<DetailMovie>) {
                val body = response.body()
                Log.e("DetailMovieViewModel", body.toString())
                data.postValue(body)
            }
        })
    }
    fun getDetailMovie(): LiveData<DetailMovie> {
        return data
    }
}