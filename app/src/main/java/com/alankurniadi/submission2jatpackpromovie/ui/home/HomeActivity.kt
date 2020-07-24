package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


    }


}