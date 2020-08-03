package com.alankurniadi.submission2jatpackpromovie.data.source

import androidx.lifecycle.LiveData
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek

interface MovieDbDataSource {

    fun getTrendingWeek(): LiveData<List<TrendingWeek.DataWeek>>

    fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>>

    fun getAiringTv(): LiveData<List<NowAiringTv.Results>>
}