package com.alankurniadi.submission2jatpackpromovie.ui.detail.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    fun getDetailMovie(id: Int?): LiveData<Detail.Movie> = movieDbRepository.getDetailMovie(id)
}