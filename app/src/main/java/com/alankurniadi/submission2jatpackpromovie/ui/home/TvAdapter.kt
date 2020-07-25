package com.alankurniadi.submission2jatpackpromovie.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_main.view.*

class TvAdapter(private val data: List<NowAiringTv.Results>): RecyclerView.Adapter<TvAdapter.TvViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_main, parent, false)
        return TvViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class TvViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(nowAiringTv: NowAiringTv.Results) {
            with(itemView) {
                Glide.with(this)
                    .load(Url.POSTER_URL+nowAiringTv.poster_path)
                    .error(R.drawable.ic_error)
                    .into(img_poster_main)
                tv_title_main.text = nowAiringTv.name
                tv_air_date.text = nowAiringTv.first_air_date
            }
        }
    }
}