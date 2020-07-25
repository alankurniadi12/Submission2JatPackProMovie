package com.alankurniadi.submission2jatpackpromovie.data.models

class NowPlayingMovie {

    data class ResponseNowPlaying (
        val results: List<Results>
    )

    data class Results (
        val id: Int = 0,
        val poster_path: String? = null,
        val original_title: String? = null,
        val vote_average: Double = 0.0
    )
}