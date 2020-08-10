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

    fun getWeekTrending() {
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
    }

}