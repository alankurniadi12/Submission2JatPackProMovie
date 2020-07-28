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
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.ui.CustomeOnItemClickListener
import com.alankurniadi.submission2jatpackpromovie.ui.detail.movie.DetailMovieActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_main.view.*

class MovieAdapter(private val activity: Activity, private val data: List<NowPlayingMovie.Results>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_main, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(nowPlaying: NowPlayingMovie.Results) {
            with(itemView) {
                Glide.with(this)
                    .load(Url.POSTER_URL+nowPlaying.poster_path)
                    .error(R.drawable.ic_error)
                    .into(img_poster_main)
                tv_title_main.text = nowPlaying.original_title
                tv_rating_main.text = nowPlaying.vote_average.toString()

                cv_item_main.setOnClickListener(CustomeOnItemClickListener(adapterPosition, object : CustomeOnItemClickListener.OnItemClickCallback {
                    override fun onItemClicked(v: View, position: Int) {
                        val intent = Intent(activity, DetailMovieActivity::class.java)
                        intent.putExtra(DetailMovieActivity.EXTRA_POSITION, position)
                        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, nowPlaying)
                        Log.e("MovieAdapter", nowPlaying.id.toString())
                        activity.startActivity(intent)
                    }

                }))
            }
        }
    }
}