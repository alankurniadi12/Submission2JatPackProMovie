package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository

class TvViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    fun getNowAiringTv(): LiveData<List<NowAiringTv.Results>> = movieDbRepository.getAiringTv()
}