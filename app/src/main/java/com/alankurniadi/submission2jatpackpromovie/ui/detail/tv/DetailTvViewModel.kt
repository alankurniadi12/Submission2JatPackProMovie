package com.alankurniadi.submission2jatpackpromovie.ui.detail.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailTvViewModel: ViewModel() {

    val dataTv = MutableLiveData<Detail.TvShow>()

    fun setDataDetailTv(id: Int?) {
        val call = RetrofitConfig().getInitInstance()
        call.getDetailTv(id).enqueue(object : Callback<Detail.TvShow>{
            override fun onFailure(call: Call<Detail.TvShow>, t: Throwable) {
                Log.e("DetailTvViewModel", t.toString())
            }
            override fun onResponse(call: Call<Detail.TvShow>, response: Response<Detail.TvShow>) {
                val body = response.body()
                Log.e("DetailTvViewModel", body.toString())
                dataTv.postValue(body)
            }
        })
    }
    fun getDataDetailTv(): LiveData<Detail.TvShow> {
        return  dataTv
    }
}