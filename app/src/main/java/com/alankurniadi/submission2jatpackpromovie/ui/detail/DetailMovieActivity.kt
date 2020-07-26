package com.alankurniadi.submission2jatpackpromovie.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val ID_MOVIE = "id_movie"
        const val EXTRA_POSITION = "extra_position"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        setSupportActionBar(tb_title_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra(ID_MOVIE) as NowPlayingMovie.Results
        Log.e("DetailMovieActivity", data.id.toString())
        val detailViewModel = ViewModelProvider(this)[DetailMovieViewModel::class.java]
        detailViewModel.setDetailMovie(data.id)
        detailViewModel.getDetailMovie().observe(this, Observer {

            tb_title_movie.title = it.title
            Log.e("DetailMovieActivity", it.title.toString())
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
