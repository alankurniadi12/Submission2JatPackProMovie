package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek
import com.alankurniadi.submission2jatpackpromovie.ui.CustomeOnItemClickListener
import com.alankurniadi.submission2jatpackpromovie.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_card_main.view.*

class WeekTrendingAdapter(private val activity: Activity, private val data: List<TrendingWeek.DataWeek>): RecyclerView.Adapter<WeekTrendingAdapter.WeekViewHolder>() {

    val movie: String = "movie"
    val tv: String = "Tvshow"
    var mediaType: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_main, parent, false)
        return WeekViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class WeekViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(trendingWeek: TrendingWeek.DataWeek) {
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
                mediaType = trendingWeek.media_type
                cv_item_main.setOnClickListener(CustomeOnItemClickListener(adapterPosition, object : CustomeOnItemClickListener.OnItemClickCallback {
                    override fun onItemClicked(v: View, position: Int) {
                        //Arahkan ke DetailActivity
                        if (mediaType != tv) {
                            Log.e("WeekTrendingAdapter", mediaType.toString())
                            val intent = Intent(activity, DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.EXTRA_POSITION, position)
                            intent.putExtra(DetailMovieActivity.FROM_TRENDING, trendingWeek)
                            activity.startActivity(intent)
                        } else {
                            // Jika typeData tv makan kirim ke DetaiilActivityTvSHow!!
                        }

                    }

                }))
            }
        }
    }
}