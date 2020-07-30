package com.alankurniadi.submission2jatpackpromovie.ui.detail.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    var dataMovie: NowPlayingMovie.Results? = null
    var dataTrending: TrendingWeek.DataWeek? = null

    companion object {
        const val FROM_TRENDING = "from_trending"
        const val EXTRA_MOVIE = "extra_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        setSupportActionBar(tb_title_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataMovie = intent.getParcelableExtra(EXTRA_MOVIE)
        dataTrending = intent.getParcelableExtra(FROM_TRENDING)

        if (dataMovie != null) {
            tb_title_movie.title = dataMovie!!.original_title
            Log.e("DetailMovieActivity", dataMovie!!.id.toString())
            val detailViewModel = ViewModelProvider(this)[DetailMovieViewModel::class.java]
            detailViewModel.setDetailMovie(dataMovie!!.id)
            detailViewModel.getDetailMovie().observe(this, Observer {
                //Log.e("DetailMovieActivity", it)
                tv_title_movie.text = it.title
                tv_vote.text = it.vote_average.toString()
                tv_release.text = it.release_date
                tv_detail.text = it.overview
                Glide.with(this)
                    .load(Url.BACKDROP_URL+it.backdrop_path)
                    .into(img_backdroup_movie)
                Glide.with(this)
                    .load(Url.POSTER_URL+it.poster_path)
                    .into(img_poster)
            })
        } else {
            tb_title_movie.title = dataTrending?.original_title
            Log.e("DetailMovieActivity", dataTrending?.id.toString())
            val detailViewModel = ViewModelProvider(this)[DetailMovieViewModel::class.java]
            detailViewModel.setDetailMovie(dataTrending?.id)
            detailViewModel.getDetailMovie().observe(this, Observer {
                //Log.e("DetailMovieActivity", it)
                tv_title_movie.text = it.title
                tv_vote.text = it.vote_average.toString()
                tv_release.text = it.release_date
                tv_detail.text = it.overview
                Glide.with(this)
                    .load(Url.BACKDROP_URL+it.backdrop_path)
                    .into(img_backdroup_movie)
                Glide.with(this)
                    .load(Url.POSTER_URL+it.poster_path)
                    .into(img_poster)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
