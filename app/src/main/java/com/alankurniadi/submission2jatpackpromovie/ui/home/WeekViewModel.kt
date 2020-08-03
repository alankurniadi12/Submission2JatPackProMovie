package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository

class WeekViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

    fun getTrendingWeek(): LiveData<List<TrendingWeek.DataWeek>> = movieDbRepository.getTrendingWeek()
}