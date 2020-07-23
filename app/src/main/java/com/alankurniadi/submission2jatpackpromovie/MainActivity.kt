package com.alankurniadi.submission2jatpackpromovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.submission2jatpackpromovie.data.models.ResultsTrendingToday
import com.alankurniadi.submission2jatpackpromovie.view.adapter.TodayTrendingAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        progress_bar_today.visibility = View.VISIBLE
        viewModel.setTrendingToday()
        viewModel.getTrendingToday().observe(this, Observer { data ->
            if (data != null){
                Log.d("getDataViewModel", data.toString())
                progress_bar_today.visibility = View.GONE
                rv_today.adapter = TodayTrendingAdapter(data)
                //adapterToday.setData(data as List<ResultsTrendingToday>)
            } else {
                Log.d("getDataViewModel", "Failed")
                progress_bar_today.visibility = View.GONE
            }
        })
        rv_today.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }


}