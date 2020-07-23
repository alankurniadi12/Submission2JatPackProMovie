package com.alankurniadi.submission2jatpackpromovie.data.models

import com.google.gson.annotations.SerializedName

data class ResultsTrendingToday(
    val id: Int = 0,
    val original_name: String? = null,
    val original_title: String? = null,
    val vote_average: Double = 0.0,
    val poster_path: String? = null
)