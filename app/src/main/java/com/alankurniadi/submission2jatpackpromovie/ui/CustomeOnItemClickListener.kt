package com.alankurniadi.submission2jatpackpromovie.ui

import android.view.View

class CustomeOnItemClickListener(private val position: Int, private val onItemClickCallback: OnItemClickCallback): View.OnClickListener {

    override fun onClick(v: View) {
        onItemClickCallback.onItemClicked(v, position)
    }

    interface OnItemClickCallback {
        fun onItemClicked(v: View, position: Int)
    }

}