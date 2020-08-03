package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alankurniadi.submission2jatpackpromovie.api.RetrofitConfig
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val movieDbRepository: MovieDbRepository): ViewModel() {

    fun getNowPlayingMovie(): LiveData<List<NowPlayingMovie.Results>> = movieDbRepository.getNowPlayingMovie()
}