package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.ResponsWeek
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeekViewModel : ViewModel() {

    val list = MutableLiveData <List<TrendingWeek>>()

    fun setTrendingWeek() {
        val call = RetrofitConfig().getInitInstance()
        call.getTrendingWeek().enqueue(object : Callback<ResponsWeek> {
            override fun onFailure(call: Call<ResponsWeek>, t: Throwable) {
                Log.e("WeekViewModel", t.toString())
            }

            override fun onResponse(
                call: Call<ResponsWeek>,
                response: Response<ResponsWeek>
            ) {
                Log.e("WeekViewModel", response.toString())
                val body = response.body()?.results
                list.postValue(body)

            }

        })
    }

    fun getTrendingWeek(): LiveData<List<TrendingWeek>> {
        return list
    }
}