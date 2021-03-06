package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.source.MovieDbRepository
import com.alankurniadi.submission2jatpackpromovie.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieDbRepository: MovieDbRepository

    @Mock
    private lateinit var observer: Observer<List<NowPlayingMovie.Results>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieDbRepository)
    }


    @Test
    fun getNowPlayingMovie() {
        val movieList = MutableLiveData<List<NowPlayingMovie.Results>>()
        val dataDummy = DataDummy.getNowPlayingMovie()
        movieList.value = dataDummy

        `when`(movieDbRepository.getNowPlayingMovie()).thenReturn(movieList)
        viewModel.getNowPlayingMovie()
        val dataMovie = viewModel.data
        verify<MovieDbRepository>(movieDbRepository).getNowPlayingMovie()

        assertNotNull(dataMovie)
        assertEquals(21, dataMovie.value?.size)

        viewModel.data.observeForever(observer)
        verify(observer).onChanged(dataDummy)
    }
}