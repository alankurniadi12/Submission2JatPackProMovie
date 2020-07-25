package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvViewModel: ViewModel() {

    val list = MutableLiveData<List<NowAiringTv.Results>>()

    fun setNowAiringTv() {
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
    }

    fun getNowAiringTv(): LiveData<List<NowAiringTv.Results>>{
        return list
    }
}