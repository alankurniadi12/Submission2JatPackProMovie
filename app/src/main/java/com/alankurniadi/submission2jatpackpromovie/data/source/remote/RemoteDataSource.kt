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

    fun getWeekTrending(callback: LoadTrendingCallback) {
        EspressoIdlingResource.increment()
        callback.onTrendingReceived(jsonHelper.loadTrendingWeek())
        EspressoIdlingResource.decrement()
    }

    fun getNowPlayingMovie(callback: LoadNowPlayingMovie) {
        EspressoIdlingResource.increment()
        callback.onPlayingNowMovie(jsonHelper.loadNowPlayingMovie())
        EspressoIdlingResource.decrement()
    }

    fun getNowAiringTv(callback: LoadNowAiringTv) {
        EspressoIdlingResource.increment()
        callback.onAiringnowTv(jsonHelper.loadTvShow())
        EspressoIdlingResource.decrement()
    }

    fun getDetailMovie(id: Int?, callback: LoadDetailMovie) {
        EspressoIdlingResource.increment()
        callback.onDetailMovie(jsonHelper.loadDetailMovie(id))
        EspressoIdlingResource.decrement()
    }

    fun getDetailTv(id: Int?, callback: LoadDetailTv) {
        EspressoIdlingResource.increment()
        callback.onDetailTv(jsonHelper.loadDetailTvShow(id))
        EspressoIdlingResource.decrement()
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
    /*fun getWeekTrending() {
        EspressoIdlingResource.increment()
        valueTrending = jsonHelper.loadTrendingWeek()
        EspressoIdlingResource.decrement()
    }

    fun getNowPlayingMovie() {
        EspressoIdlingResource.increment()
        valueMovie = jsonHelper.loadNowPlayingMovie()
        EspressoIdlingResource.decrement()
    }

    fun getNowAiringTv() {
        EspressoIdlingResource.increment()
        valueTv = jsonHelper.loadTvShow()
        EspressoIdlingResource.decrement()
    }

    fun getDetailMovie(id: Int?) {
        EspressoIdlingResource.increment()
        valueMovieDetail = jsonHelper.loadDetailMovie(id)
        EspressoIdlingResource.decrement()
    }

    fun getDetailTv(id: Int?){
        EspressoIdlingResource.increment()
        valueTvDetail =jsonHelper.loadDetailTvShow(id)
        EspressoIdlingResource.decrement()
    }*/


}