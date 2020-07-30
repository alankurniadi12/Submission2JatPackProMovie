package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.ui.detail.movie.DetailMovieActivity
import com.alankurniadi.submission2jatpackpromovie.ui.detail.tv.DetailTvActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var trendingAdapter: WeekTrendingAdapter
    private lateinit var tvAdapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // trending week
        val viewModelWeek = ViewModelProvider(this)[WeekViewModel::class.java]
        progress_bar_week.visibility = View.VISIBLE
        viewModelWeek.setTrendingWeek()
        viewModelWeek.getTrendingWeek().observe(this, Observer {
            if (it != null){
                progress_bar_week.visibility = View.GONE
                trendingAdapter = WeekTrendingAdapter(it)
                rv_this_week.adapter = trendingAdapter
                rv_this_week.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                // Set OnClick Trending
                setClickItemTrending()
            } else {
                progress_bar_week.visibility = View.GONE
            }

        })

        // playing now movie
        val viewmodelMovie = ViewModelProvider(this)[MovieViewModel::class.java]
        progress_movie.visibility = View.VISIBLE
        viewmodelMovie.setNowPlayingMovie()
        viewmodelMovie.getNowPlayingMovie().observe(this, Observer {
            if (it != null) {
                progress_movie.visibility = View.GONE
                movieAdapter = MovieAdapter(this, it)
                rv_movie.adapter = movieAdapter
                rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }else {
                progress_movie.visibility = View.GONE
            }
        })

        // Airing now tv
        val viewModelTv = ViewModelProvider(this)[TvViewModel::class.java]
        progress_tv.visibility = View.VISIBLE
        viewModelTv.setNowAiringTv()
        viewModelTv.getNowAiringTv().observe(this, Observer {
            if (it != null) {
                progress_tv.visibility = View.GONE
                tvAdapter = TvAdapter(this, it)
                rv_tv.adapter = tvAdapter
                rv_tv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }else {
                progress_tv.visibility = View.GONE
            }
        })
    }

    private fun setClickItemTrending() {
        trendingAdapter.setOnItemClickCallback(object : WeekTrendingAdapter.OnitemClickCallback {
            override fun onItemClicked(data: TrendingWeek.DataWeek) {
                val mediaType = data.media_type
                when(mediaType) {
                    "movie" -> {
                        val intentMovie = Intent(this@HomeActivity, DetailMovieActivity::class.java)
                        intentMovie.putExtra(DetailMovieActivity.FROM_TRENDING, data)
                        startActivity(intentMovie)
                    }
                    "tv" -> {
                        val intentTv = Intent(this@HomeActivity, DetailTvActivity::class.java)
                        intentTv.putExtra(DetailTvActivity.FROM_TRENDING, data)
                        startActivity(intentTv)
                    }
                }
            }
        })
    }
}