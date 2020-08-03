package com.alankurniadi.submission2jatpackpromovie.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.data.source.remote.RemoteDataSource
import kotlinx.android.synthetic.main.item_card_main.view.*

class MovieDbRepository private constructor(private val remoteDataSource: RemoteDataSource): MovieDbDataSource {

    companion object {
        @Volatile
        private var instance: MovieDbRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieDbRepository = instance ?: synchronized(this) {
            instance ?: MovieDbRepository(remoteDataSource)
        }
    }

    override fun getTrendingWeek(): LiveData<List<TrendingWeek.DataWeek>> = remoteDataSource.getWeekTrending()

    override fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>> = remoteDataSource.getNowPlayingMovie()

    override fun getAiringTv(): LiveData<List<NowAiringTv.Results>> = remoteDataSource.getNowAiringTv()

    override fun getDetailMovie(id: Int?): LiveData<Detail.Movie> = remoteDataSource.getDetailMovie(id)

    override fun getDetailTv(id: Int?): LiveData<Detail.TvShow> = remoteDataSource.getDetailTv(id)
}