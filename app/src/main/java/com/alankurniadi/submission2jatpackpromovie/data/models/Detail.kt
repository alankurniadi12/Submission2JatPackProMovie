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
        val created_by: List<CreateBy>,
        val backdrop_path: String? = null,
        val name: String? = null,
        val overview: String? = null,
        val poster_path: String? = null,
        val first_air_date: String? = null,
        val vote_average: Double? = null
    )
    data class  CreateBy (
        val id: Int? = null,
        val credit_id: String? = null,
        val name: String? = null,
        val profile_path: String? = null
    )
}

