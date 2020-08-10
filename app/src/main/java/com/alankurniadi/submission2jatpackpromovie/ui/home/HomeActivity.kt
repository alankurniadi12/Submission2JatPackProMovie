package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.ui.detail.movie.DetailMovieActivity
import com.alankurniadi.submission2jatpackpromovie.ui.detail.tv.DetailTvActivity
import com.alankurniadi.submission2jatpackpromovie.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var trendingAdapter: WeekTrendingAdapter
    private lateinit var tvAdapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = ViewModelFactory.getInstance(this)

        // trending week
        val viewModelWeek = ViewModelProvider(this, factory)[WeekViewModel::class.java]
        progress_bar_week.visibility = View.VISIBLE
        viewModelWeek.getTrendingWeek()
        viewModelWeek.data.observe(this, Observer {
            Log.e("HomeActivity", "Observer TrendingWeek: "+ it.toString())
            if (it != null){
                progress_bar_week.visibility = View.GONE
                trendingAdapter = WeekTrendingAdapter(it)
                trendingAdapter.notifyDataSetChanged()
                rv_this_week.adapter = trendingAdapter
                rv_this_week.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

                setClickItemTrending()
            } else {
                progress_bar_week.visibility = View.GONE
            }

        })

        // playing now movie
        val viewmodelMovie = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        progress_movie.visibility = View.VISIBLE
        viewmodelMovie.getNowPlayingMovie()
        viewmodelMovie.data.observe(this, Observer {
            Log.e("HomeActivity", "Observer PlayingNow Movie: "+ it.toString())
            if (it != null) {
                progress_movie.visibility = View.GONE
                movieAdapter = MovieAdapter(this, it)
                movieAdapter.notifyDataSetChanged()
                rv_movie.adapter = movieAdapter
                rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }else {
                progress_movie.visibility = View.GONE
            }
        })

        // Airing now tv
        val viewModelTv = ViewModelProvider(this, factory)[TvViewModel::class.java]
        progress_tv.visibility = View.VISIBLE
        viewModelTv.getNowAiringTv()
        viewModelTv.data.observe(this, Observer {
            Log.e("HomeActivity", "Observer Airing TvSHow: "+ it.toString())
            if (it != null) {
                progress_tv.visibility = View.GONE
                tvAdapter = TvAdapter(this, it)
                tvAdapter.notifyDataSetChanged()
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
                when(data.media_type) {
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