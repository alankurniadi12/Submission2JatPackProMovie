package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.submission2jatpackpromovie.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

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
                rv_this_week.adapter = WeekTrendingAdapter(it)
                rv_this_week.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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
                rv_movie.adapter = MovieAdapter(it)
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
                rv_tv.adapter = TvAdapter(it)
                rv_tv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }else {
                progress_tv.visibility = View.GONE
            }
        })
    }
}