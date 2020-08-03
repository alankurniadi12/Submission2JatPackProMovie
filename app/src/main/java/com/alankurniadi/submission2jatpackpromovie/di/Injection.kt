package com.alankurniadi.submission2jatpackpromovie.di

import android.content.Context
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository
import com.alankurniadi.submission2jatpackpromovie.data.source.remote.RemoteDataSource
import com.alankurniadi.submission2jatpackpromovie.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieDbRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieDbRepository.getInstance(remoteDataSource)
    }
}