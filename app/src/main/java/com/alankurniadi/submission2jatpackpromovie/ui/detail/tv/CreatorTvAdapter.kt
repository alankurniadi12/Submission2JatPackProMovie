package com.alankurniadi.submission2jatpackpromovie.ui.detail.tv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.api.Url
import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list_simple.view.*

class CreatorTvAdapter(private val data : List<Detail.CreateBy>): RecyclerView.Adapter<CreatorTvAdapter.CreatorTvViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorTvViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_simple, parent, false)
        return CreatorTvViewModel(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CreatorTvViewModel, position: Int) {
        holder.bind(data[position])
    }

    class CreatorTvViewModel(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(detail: Detail.CreateBy) {
            Log.e("CreatorTvAdapter", detail.toString())
            with(itemView) {
                Glide.with(this)
                    .load(Url.POSTER_PROFILE+detail.profile_path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error_person)
                    .into(img_item_simple)
                tv_creator.text = detail.name
            }
        }
    }

}