package com.alankurniadi.submission2jatpackpromovie.ui.detail.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository

class DetailTvViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    fun getDataDetailTv(id: Int?): LiveData<Detail.TvShow> = movieDbRepository.getDetailTv(id)
}