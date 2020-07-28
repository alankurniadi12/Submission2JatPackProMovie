package com.alankurniadi.submission2jatpackpromovie.ui.detail.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_tv.*

class DetailTvActivity : AppCompatActivity() {

    private var dataTrending: TrendingWeek.DataWeek? = null
    companion object {
        const val FROM_TRENDING = "from_trending"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        setSupportActionBar(tb_title_tv)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataTrending = intent.getParcelableExtra(FROM_TRENDING)
        Log.e("DetailTvActivity", dataTrending.toString())
        if (dataTrending != null) {
            tb_title_tv.title = dataTrending?.original_name
            val detailViewModel = ViewModelProvider(this)[DetailTvViewModel::class.java]
            detailViewModel.setDataDetailTv(dataTrending!!.id)
            detailViewModel.getDataDetailTv().observe(this, Observer {
                Log.e("DetailTvActivity", it.toString())
                tv_vote_tv.text = it.vote_average.toString()
                tv_release_tv.text = it.release_date
                tv_detail_tv.text = it.overview
                Glide.with(this)
                    .load(Url.BACKDROP_URL+it.backdrop_path)
                    .into(img_backdroup_tv)
                Glide.with(this)
                    .load(Url.POSTER_URL+it.poster_path)
                    .into(img_poster_tv)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}