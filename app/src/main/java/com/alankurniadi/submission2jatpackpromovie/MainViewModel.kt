package com.alankurniadi.submission2jatpackpromovie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.ResponsTrendingToday
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.ResultsTrendingToday
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val listTrendingToday = MutableLiveData <List<ResultsTrendingToday?>?>()

    fun setTrendingToday() {
        val call = RetrofitConfig().getInitInstance()
        call.getTrendingToday().enqueue(object : Callback <ResponsTrendingToday>{
            override fun onFailure(call: Call<ResponsTrendingToday>, t: Throwable) {
                Log.e("MainViewModel", t.localizedMessage)
            }
            override fun onResponse(
                call: Call<ResponsTrendingToday>,
                response: Response<ResponsTrendingToday>
            ) {
                Log.e("MainViewModel", response.toString())
                val body = response.body()?.results
                listTrendingToday.postValue(body)
            }
        })
    }

    fun getTrendingToday(): LiveData <List<ResultsTrendingToday?>?> {
        return listTrendingToday
    }
}
