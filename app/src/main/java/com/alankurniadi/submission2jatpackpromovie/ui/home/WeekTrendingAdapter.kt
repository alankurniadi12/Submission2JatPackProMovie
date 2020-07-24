package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_main.view.*

class WeekTrendingAdapter(private val data: List<TrendingWeek>): RecyclerView.Adapter<WeekTrendingAdapter.WeekViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_main, parent, false)
        return WeekViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class WeekViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(trendingWeek: TrendingWeek) {
            with(itemView) {
                Glide.with(this)
                    .load(Url.POSTER_URL+trendingWeek.poster_path)
                    .error(R.drawable.ic_error)
                    .into(img_poster_main)
                if (trendingWeek.original_name != null) {
                    tv_title_main.text = trendingWeek.original_name
                } else {
                    tv_title_main.text = trendingWeek.original_title
                }
                tv_rating_main.text = trendingWeek.vote_average.toString()
            }
        }
    }
}