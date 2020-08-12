package com.alankurniadi.submission2jatpackpromovie.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    override fun getTrendingWeek(): LiveData<List<TrendingWeek.DataWeek>> {
        var weekTrendingResult = MutableLiveData<List<TrendingWeek.DataWeek>>()
        remoteDataSource.getWeekTrending(object : RemoteDataSource.LoadTrendingCallback {
            override fun onTrendingReceived(weekResponse: MutableLiveData<List<TrendingWeek.DataWeek>>) {
                weekTrendingResult = weekResponse
            }
        })
        return weekTrendingResult
    }

    override fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>> {
        var nowPlayingMovie = MutableLiveData<List<NowPlayingMovie.Results>>()
        remoteDataSource.getNowPlayingMovie(object : RemoteDataSource.LoadNowPlayingMovie {
            override fun onPlayingNowMovie(movieResponse: MutableLiveData<List<NowPlayingMovie.Results>>) {
                nowPlayingMovie = movieResponse
            }

        })
        return nowPlayingMovie
    }

    override fun getAiringTv(): LiveData<List<NowAiringTv.Results>>{
        var airingNowTv = MutableLiveData<List<NowAiringTv.Results>>()
        remoteDataSource.getNowAiringTv(object : RemoteDataSource.LoadNowAiringTv {
            override fun onAiringnowTv(airingTv: MutableLiveData<List<NowAiringTv.Results>>) {
                airingNowTv = airingTv
            }

        })
        return airingNowTv
    }

    override fun getDetailMovie(id: Int?): LiveData<Detail.Movie> {
        var detail = MutableLiveData<Detail.Movie>()
        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovie {
            override fun onDetailMovie(detailMovie: MutableLiveData<Detail.Movie>) {
                detail = detailMovie
            }
        })
        return detail
    }

    override fun getDetailTv(id: Int?): LiveData<Detail.TvShow> {
        var detail = MutableLiveData<Detail.TvShow>()
        remoteDataSource.getDetailTv(id, object : RemoteDataSource.LoadDetailTv {
            override fun onDetailTv(detailTv: MutableLiveData<Detail.TvShow>) {
                detail = detailTv
            }

        })
        return detail
    }
}
