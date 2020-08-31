package com.alankurniadi.submission2jatpackpromovie.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class NowAiringTv {

    data class ResponseAiringTv(
        val results: ArrayList<Results>
    )

    @Parcelize
    data class Results(
        val id: Int? = null,
        val name: String? = null,
        val first_air_date: String? = null,
        val poster_path: String? = null
    ): Parcelable
}