package com.alankurniadi.submission2jatpackpromovie.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class TrendingWeek {
    data class ResponsWeek(
        val results: ArrayList<DataWeek>
    )

    @Parcelize
    data class DataWeek(
        val id: Int = 0,
        val vote_average: Double = 0.0,
        val original_name: String? = null,
        val original_title: String? = null,
        val poster_path: String? = null,
        val media_type: String? = null
    ): Parcelable
}


