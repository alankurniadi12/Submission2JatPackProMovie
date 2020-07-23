package com.alankurniadi.submission2jatpackpromovie.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.ResultsTrendingToday
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_main.view.*

class TodayTrendingAdapter(private val data: List<ResultsTrendingToday?>?): RecyclerView.Adapter<TodayTrendingAdapter.TodayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_main, parent, false)
        return TodayViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?:0

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        data?.get(position)?.let { holder.bind(it) }
    }


    class TodayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(trendingToday: ResultsTrendingToday) {
            with(itemView) {
                Glide.with(itemView)
                    .load(Url.POSTER_URL+trendingToday.poster_path)
                    .into(img_poster_main)
                if (trendingToday.original_name != null) {
                    tv_title_main.text = trendingToday.original_name
                } else {
                    tv_title_main.text = trendingToday.original_title
                }
                tv_rating_main.text = trendingToday.vote_average.toString()
            }
        }
    }
}