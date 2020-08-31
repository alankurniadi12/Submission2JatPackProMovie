package com.alankurniadi.submission2jatpackpromovie.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class NowPlayingMovie {

    data class ResponseNowPlaying (
        val results: ArrayList<Results>
    )

    @Parcelize
    data class Results (
        val id: Int = 0,
        val poster_path: String? = null,
        val original_title: String? = null,
        val vote_average: Double = 0.0
    ): Parcelable
}