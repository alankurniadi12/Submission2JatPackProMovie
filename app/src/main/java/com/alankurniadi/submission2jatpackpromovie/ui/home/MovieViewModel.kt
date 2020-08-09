package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository

class MovieViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    lateinit var data: LiveData<List<NowPlayingMovie.Results>>

    fun getNowPlayingMovie() {
        data = movieDbRepository.getNowPlayingMovie()
    }
}