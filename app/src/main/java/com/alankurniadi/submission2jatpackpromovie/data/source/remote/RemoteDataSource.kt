package com.alankurniadi.submission2jatpackpromovie.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper)
        }
    }

    fun getWeekTrending(callback: LoadTrendingCallback) {
        callback.onTrendingReceived(jsonHelper.loadTrendingWeek())
    }

    fun getNowPlayingMovie(callback: LoadNowPlayingMovie) {
        callback.onPlayingNowMovie(jsonHelper.loadNowPlayingMovie())
    }

    fun getNowAiringTv(callback: LoadNowAiringTv) {
        callback.onAiringnowTv(jsonHelper.loadTvShow())
    }

    fun getDetailMovie(id: Int?, callback: LoadDetailMovie) {
        callback.onDetailMovie(jsonHelper.loadDetailMovie(id))
    }

    fun getDetailTv(id: Int?, callback: LoadDetailTv) {
        callback.onDetailTv(jsonHelper.loadDetailTvShow(id))
    }



    interface LoadTrendingCallback{
        fun onTrendingReceived(weekResponse: MutableLiveData<List<TrendingWeek.DataWeek>>)
    }

    interface LoadNowPlayingMovie {
        fun onPlayingNowMovie(movieResponse: MutableLiveData<List<NowPlayingMovie.Results>>)
    }

    interface LoadNowAiringTv {
        fun onAiringnowTv(airingTv: MutableLiveData<List<NowAiringTv.Results>>)
    }

    interface LoadDetailMovie {
        fun onDetailMovie(detailMovie: MutableLiveData<Detail.Movie>)
    }

    interface LoadDetailTv {
        fun onDetailTv(detailTv: MutableLiveData<Detail.TvShow>)
    }

}