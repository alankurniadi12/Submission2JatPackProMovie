package com.alankurniadi.submission2jatpackpromovie.data.models

class Detail {
    data class  Movie (
        val id: Int? = null,
        val backdrop_path: String? = null,
        val title: String? = null,
        val overview: String? = null,
        val poster_path: String? = null,
        val release_date: String? = null,
        val vote_average: Double? = null
    )
    data class TvShow (
        val id: Int? = null,
        val backdrop_path: String? = null,
        val title: String? = null,
        val overview: String? = null,
        val poster_path: String? = null,
        val release_date: String? = null,
        val vote_average: Double? = null
    )
}

