package com.alankurniadi.submission2jatpackpromovie.data.models

import java.util.*

class NowAiringTv {

    data class ResponseAiringTv(
        val results: List<Results>
    )

    data class Results(
        val id: Int? = null,
        val name: String? = null,
        val first_air_date: String? = null,
        val poster_path: String? = null
    )
}