package com.alankurniadi.submission2jatpackpromovie.ui.detail.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_tv.*

class DetailTvActivity : AppCompatActivity() {

    private var dataTrending: TrendingWeek.DataWeek? = null
    private var dataTvshow: NowAiringTv.Results? = null
    private lateinit var creatorTvAdapter: CreatorTvAdapter
    companion object {
        const val FROM_TRENDING = "from_trending"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        setSupportActionBar(tb_title_tv)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataTvshow = intent.getParcelableExtra(EXTRA_TV)
        dataTrending = intent.getParcelableExtra(FROM_TRENDING)
        //Log.e("DetailTvActivity", "Data Trending: $dataTrending")

        val factory = ViewModelFactory.getInstance(this)

        if (dataTrending != null) {
            tb_title_tv.title = dataTrending?.original_name
            val detailViewModel = ViewModelProvider(this, factory)[DetailTvViewModel::class.java]
            //detailViewModel.setDataDetailTv(dataTrending!!.id)
            detailViewModel.getDataDetailTv(dataTrending!!.id).observe(this, Observer {
                Log.e("DetailTvActivity", "dataTrending: $it")
                tv_title_tv.text = it.name
                tv_vote_tv.text = it.vote_average.toString()
                tv_release_tv.text = it.first_air_date
                tv_detail_tv.text = it.overview
                Glide.with(this)
                    .load(Url.BACKDROP_URL+it.backdrop_path)
                    .into(img_backdroup_tv)
                Glide.with(this)
                    .load(Url.POSTER_URL+it.poster_path)
                    .into(img_poster_tv)

                setCreatorTv(it)
            })
        } else {
            Log.e("DetailTvActivity", "dataTvshow: $dataTvshow")
            tb_title_tv.title = dataTvshow?.name
            val detailViewModel = ViewModelProvider(this, factory)[DetailTvViewModel::class.java]
            //detailViewModel.setDataDetailTv(dataTvshow?.id)
            detailViewModel.getDataDetailTv(dataTvshow?.id).observe(this, Observer {
                Log.e("DetailTvActivity", "dataTvshowViewModel: $it")
                tv_title_tv.text = it.name
                tv_vote_tv.text = it.vote_average.toString()
                tv_release_tv.text = it.first_air_date
                tv_detail_tv.text = it.overview
                Glide.with(this)
                    .load(Url.BACKDROP_URL+it.backdrop_path)
                    .into(img_backdroup_tv)
                Glide.with(this)
                    .load(Url.POSTER_URL+it.poster_path)
                    .into(img_poster_tv)

                setCreatorTv(it)
            })
        }
    }

    private fun setCreatorTv(data: Detail.TvShow) {
        creatorTvAdapter = CreatorTvAdapter(data.created_by)
        rv_creator.adapter = creatorTvAdapter
        rv_creator.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,  false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}