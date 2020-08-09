package com.alankurniadi.submission2jatpackpromovie.data.source

import androidx.lifecycle.LiveData
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.data.source.remote.RemoteDataSource

class MovieDbRepository private constructor(private val remoteDataSource: RemoteDataSource): MovieDbDataSource {

    companion object {
        @Volatile
        private var instance: MovieDbRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieDbRepository = instance ?: synchronized(this) {
            instance ?: MovieDbRepository(remoteDataSource)
        }
    }

    override fun getTrendingWeek(): LiveData<List<TrendingWeek.DataWeek>> = remoteDataSource.getWeekTrending()

    /*override fun getTrendingWeek(): LiveData<List<TrendingWeek.DataWeek>> {
        val trendingResult = MutableLiveData<List<TrendingWeek.DataWeek>>()
        remoteDataSource.getWeekTrending(object : RemoteDataSource.LoadWeekTrending {
            override fun onAllWeekTrending(trendingWeek: MutableLiveData<List<TrendingWeek.DataWeek>>) {
                val trendingWeekList = trendingWeek.value
                trendingResult.postValue(trendingWeekList)
            }
        })
        return trendingResult
    }*/

    override fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>> = remoteDataSource.getNowPlayingMovie()
    /*override fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>> {
        val nowPlayingMovie = MutableLiveData<List<NowPlayingMovie.Results>>()
        remoteDataSource.getNowPlayingMovie(object : RemoteDataSource.LoadNowPlayingMovie {
            override fun onNowPlayingMovie(nowPlayingMovie: MutableLiveData<List<NowPlayingMovie.Results>>) {
                val movieList = nowPlayingMovie.value
                nowPlayingMovie.postValue(movieList)
            }
        })
        return nowPlayingMovie
    }*/

    override fun getAiringTv(): LiveData<List<NowAiringTv.Results>> = remoteDataSource.getNowAiringTv()
    /*override fun getAiringTv(): LiveData<List<NowAiringTv.Results>> {
        val airingTv = MutableLiveData<List<NowAiringTv.Results>>()
        remoteDataSource.getNowAiringTv(object : RemoteDataSource.LoadNowAiringTv {
            override fun onNowAiringTv(nowAiringTv: MutableLiveData<List<NowAiringTv.Results>>) {
                val tvList = nowAiringTv.value
                airingTv.postValue(tvList)
            }
        })
        return airingTv
    }*/

    override fun getDetailMovie(id: Int?): LiveData<Detail.Movie> = remoteDataSource.getDetailMovie(id)
    /*override fun getDetailMovie(id: Int?): LiveData<Detail.Movie> {
        val detailMovie = MutableLiveData<Detail.Movie>()
        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovie {
            override fun onDetailMovie(detail: MutableLiveData<Detail.Movie>) {
                val movie = detail.value
                detailMovie.postValue(movie)
            }
        })
        return detailMovie
    }*/

    override fun getDetailTv(id: Int?): LiveData<Detail.TvShow> = remoteDataSource.getDetailTv(id)
    /*override fun getDetailTv(id: Int?): LiveData<Detail.TvShow> {
        val detailTv = MutableLiveData<Detail.TvShow>()
        remoteDataSource.getDetailTv(id, object : RemoteDataSource.LoadDetailTv {
            override fun onDetailTv(detail: MutableLiveData<Detail.TvShow>) {
                val tv = detail.value
                detailTv.postValue(tv)
            }
        })
        return detailTv
    }*/
}