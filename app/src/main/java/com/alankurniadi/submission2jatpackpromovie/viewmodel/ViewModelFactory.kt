package com.alankurniadi.submission2jatpackpromovie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository
import com.alankurniadi.submission2jatpackpromovie.di.Injection
import com.alankurniadi.submission2jatpackpromovie.ui.detail.movie.DetailMovieViewModel
import com.alankurniadi.submission2jatpackpromovie.ui.detail.tv.DetailTvViewModel
import com.alankurniadi.submission2jatpackpromovie.ui.home.MovieViewModel
import com.alankurniadi.submission2jatpackpromovie.ui.home.TvViewModel
import com.alankurniadi.submission2jatpackpromovie.ui.home.WeekViewModel

class ViewModelFactory private constructor(private val movieDbRepository: MovieDbRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository(context))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(WeekViewModel::class.java) -> {
                return WeekViewModel(movieDbRepository) as T
            }

            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieDbRepository) as T
            }

            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                return TvViewModel(movieDbRepository) as T
            }

            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(movieDbRepository) as T
            }

            modelClass.isAssignableFrom(DetailTvViewModel::class.java) -> {
                return DetailTvViewModel(movieDbRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: "+ modelClass.name)
        }
    }
}