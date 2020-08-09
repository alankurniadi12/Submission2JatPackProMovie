package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository

class TvViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    lateinit var data: LiveData<List<NowAiringTv.Results>>

    fun getNowAiringTv() {
        data = movieDbRepository.getAiringTv()
    }
}