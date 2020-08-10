package com.alankurniadi.submission2jatpackpromovie.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.utils.EspressoIdlingResource
import com.alankurniadi.submission2jatpackpromovie.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){


    lateinit var valueTrending: MutableLiveData<List<TrendingWeek.DataWeek>>
    lateinit var valueMovie: MutableLiveData<List<NowPlayingMovie.Results>>
    lateinit var valueTv: MutableLiveData<List<NowAiringTv.Results>>
    lateinit var valueMovieDetail: MutableLiveData<Detail.Movie>
    lateinit var valueTvDetail: MutableLiveData<Detail.TvShow>


    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper)
        }
    }

    //For HomeActivity
    //fun getWeekTrending(): MutableLiveData<List<TrendingWeek.DataWeek>> = jsonHelper.loadTrendingWeek()
    fun getWeekTrending() {
        EspressoIdlingResource.increment()
        valueTrending = jsonHelper.loadTrendingWeek()
        EspressoIdlingResource.decrement()
    }

    //fun getNowPlayingMovie(): MutableLiveData<List<NowPlayingMovie.Results>> = jsonHelper.loadNowPlayingMovie()
    fun getNowPlayingMovie() {
        EspressoIdlingResource.increment()
        valueMovie = jsonHelper.loadNowPlayingMovie()
        EspressoIdlingResource.decrement()
    }

    //fun getNowAiringTv(): MutableLiveData<List<NowAiringTv.Results>> = jsonHelper.loadTvShow()
    fun getNowAiringTv() {
        EspressoIdlingResource.increment()
        valueTv = jsonHelper.loadTvShow()
        EspressoIdlingResource.decrement()
    }

    //DetailMovieActivity
    //fun getDetailMovie(id: Int?): MutableLiveData<Detail.Movie> = jsonHelper.loadDetailMovie(id)
    fun getDetailMovie(id: Int?) {
        EspressoIdlingResource.increment()
        valueMovieDetail = jsonHelper.loadDetailMovie(id)
        EspressoIdlingResource.decrement()
    }

    //DetailTvActivity
    fun getDetailTv(id: Int?){
        EspressoIdlingResource.increment()
        valueTvDetail =jsonHelper.loadDetailTvShow(id)
        EspressoIdlingResource.decrement()
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