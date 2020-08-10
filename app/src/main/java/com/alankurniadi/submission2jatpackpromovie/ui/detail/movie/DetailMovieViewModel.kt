package com.alankurniadi.submission2jatpackpromovie.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository

class DetailMovieViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    fun getDetailMovie(id: Int?): LiveData<Detail.Movie> = movieDbRepository.getDetailMovie(id)
}