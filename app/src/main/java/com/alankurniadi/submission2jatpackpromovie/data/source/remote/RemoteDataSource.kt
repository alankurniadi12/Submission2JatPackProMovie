package com.alankurniadi.submission2jatpackpromovie.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.utils.EspressoIdlingResource
import com.alankurniadi.submission2jatpackpromovie.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper)
        }
    }

    //For HomeActivity
    //fun getWeekTrending(): MutableLiveData<List<TrendingWeek.DataWeek>> = jsonHelper.loadTrendingWeek()
    fun getWeekTrending() : MutableLiveData<List<TrendingWeek.DataWeek>> {
        EspressoIdlingResource.increment()
        val value = jsonHelper.loadTrendingWeek()
        EspressoIdlingResource.decrement()
        return value
    }

    //fun getNowPlayingMovie(): MutableLiveData<List<NowPlayingMovie.Results>> = jsonHelper.loadNowPlayingMovie()
    fun getNowPlayingMovie(): MutableLiveData<List<NowPlayingMovie.Results>> {
        EspressoIdlingResource.increment()
        val value = jsonHelper.loadNowPlayingMovie()
        EspressoIdlingResource.decrement()
        return value
    }

    //fun getNowAiringTv(): MutableLiveData<List<NowAiringTv.Results>> = jsonHelper.loadTvShow()
    fun getNowAiringTv(): MutableLiveData<List<NowAiringTv.Results>> {
        EspressoIdlingResource.increment()
        val value = jsonHelper.loadTvShow()
        EspressoIdlingResource.decrement()
        return value
    }

    //DetailMovieActivity
    //fun getDetailMovie(id: Int?): MutableLiveData<Detail.Movie> = jsonHelper.loadDetailMovie(id)
    fun getDetailMovie(id: Int?): MutableLiveData<Detail.Movie> {
        EspressoIdlingResource.increment()
        val value =jsonHelper.loadDetailMovie(id)
        EspressoIdlingResource.decrement()
        return value
    }

    //DetailTvActivity
    fun getDetailTv(id: Int?):  MutableLiveData<Detail.TvShow>{
        EspressoIdlingResource.increment()
        val value =jsonHelper.loadDetailTvShow(id)
        EspressoIdlingResource.decrement()
        return value
    }



    /*interface LoadWeekTrending {
        fun onAllWeekTrending(trendingWeek: MutableLiveData<List<TrendingWeek.DataWeek>>)
    }

    interface LoadNowPlayingMovie {
        fun onNowPlayingMovie(nowPlayingMovie: MutableLiveData<List<NowPlayingMovie.Results>>)
    }

    interface LoadNowAiringTv {
        fun onNowAiringTv(nowAiringTv: MutableLiveData<List<NowAiringTv.Results>>)
    }

    interface LoadDetailMovie {
        fun onDetailMovie(detail: MutableLiveData<Detail.Movie>)
    }

    interface LoadDetailTv {
        fun onDetailTv(detail: MutableLiveData<Detail.TvShow>)
    }*/


}