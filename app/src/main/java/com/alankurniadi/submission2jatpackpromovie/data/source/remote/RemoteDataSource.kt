package com.alankurniadi.submission2jatpackpromovie.data.source.remote

import androidx.lifecycle.MutableLiveData
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

    fun getWeekTrending(): MutableLiveData<List<TrendingWeek.DataWeek>> = jsonHelper.loadTrendingWeek()

    fun getNowPlayingMovie(): MutableLiveData<List<NowPlayingMovie.Results>> = jsonHelper.loadNowPlayingMovie()

    fun getNowAiringTv(): MutableLiveData<List<NowAiringTv.Results>> = jsonHelper.loadTvShow()

}