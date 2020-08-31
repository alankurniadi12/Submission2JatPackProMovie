package com.alankurniadi.submission2jatpackpromovie.utils

import com.alankurniadi.submission2jatpackpromovie.data.models.Detail
import com.alankurniadi.submission2jatpackpromovie.data.models.NowAiringTv
import com.alankurniadi.submission2jatpackpromovie.data.models.NowPlayingMovie
import com.alankurniadi.submission2jatpackpromovie.data.models.TrendingWeek

object DataDummy {

    fun getTrending(): List<TrendingWeek.DataWeek> {

        val trending = ArrayList<TrendingWeek.DataWeek>()

        trending.add(TrendingWeek.DataWeek(
            75006,
            8.4,
            "The Umbrella Academy",
            "The Umbrella Academy",
            "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
            "tv"))

        trending.add(TrendingWeek.DataWeek(
            516486,
            7.5,
            "Greyhound",
            "Greyhound",
            "/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            583083,
            8.2,
            "The Kissing Booth 2",
            "The Kissing Booth 2",
            "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            547016,
            7.4,
            "The Old Guard",
            "The Old Guard",
            "/m0ObOaJBerZ3Unc74l471ar8Iiy.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            703745,
            7.5,
            "Deep Blue Sea 3",
            "Deep Blue Sea 3",
            "/hIHtyIYgBqHybOgUdoAmveipuiO.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"))

        trending.add(TrendingWeek.DataWeek(
            385103,
            7.6,
            "Scoob!",
            "Scoob!",
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "movie"
        ))

        return trending
    }

    fun getNowPlayingMovie(): List<NowPlayingMovie.Results> {

        val movie = ArrayList<NowPlayingMovie.Results>()

        movie.add(NowPlayingMovie.Results(
            385103,
            "/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg",
            "Scoob!",
            7.6 ))

        movie.add(NowPlayingMovie.Results(
            27205,
            "/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg",
            "Inception",
            8.3 ))

        movie.add(NowPlayingMovie.Results(
            601165,
            "/bhNHCeJDFDaB00A46AoCw2mggdE.jpg",
            "Legacy of Lies",
            5.9 ))

        movie.add(NowPlayingMovie.Results(
            496243,
            "/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
            "Parasite",
            8.5 ))

        movie.add(NowPlayingMovie.Results(
            531876,
            "/hPkqY2EMqWUnFEoedukilIUieVG.jpg",
            "The Outpost",
            6.6 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        movie.add(NowPlayingMovie.Results(
            454626,
            "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
            "Sonic the Hedgehog",
            7.5 ))

        return movie
    }

    fun getAiringTvShow(): List<NowAiringTv.Results> {

        val tvShow = ArrayList<NowAiringTv.Results>()

        tvShow.add(NowAiringTv.Results(
            60572,
            "Pokémon",
            "1997-04-01",
            "/rOuGm07PxBhEsK9TaGPRQVJQm1X.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            2661,
            "Kamen Rider",
            "1971-04-03",
            "/o57T19zgZakEpre3d9ddy1UZonp.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45253,
            "Super Sentai",
            "1975-04-05",
            "/tDq8av51oHR8YWgkiHQ2oeRO5iL.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            10160,
            "The Alienist",
            "2018-01-22",
            "/1qzuS7b2XjiVcWwmDkOyE5hIxUM.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            73586,
            "Yellowstone",
            "2018-06-20",
            "/43nVQqVsrshaOx9GfJq6JstsfCX.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        tvShow.add(NowAiringTv.Results(
            45782,
            "Sword Art Online",
            "2012-07-08",
            "/zLdXxodgz0UN0RCca8uxBq3EGTg.jpg"
        ))

        return tvShow
    }

    fun getMovieDetail():Detail.Movie {

        return Detail.Movie(
            385103,
            "/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg",
            "Scoob!",
            "In Scooby-Doo’s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global “dogpocalypse,” the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.",
            "/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg",
            "2020-07-08",
            7.6
        )
    }

    fun getTvShowDetail(): List<Detail.TvShow> {
        val detail = ArrayList<Detail.TvShow>()

        detail.add(Detail.TvShow (
            75006,
            listOf(
                Detail.CreateBy(1227939, "5bb869f5c3a368241b008423", "Steve Blackman", "/ui2tZkndNgit4Gsb4nRPzKyjPZx.jpg")
            ) as ArrayList<Detail.CreateBy>,
            "/qJxzjUjCpTPvDHldNnlbRC4OqEh.jpg",
            "The Umbrella Academy",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
            "2019-02-15",
            8.4
        ))

        detail.add(Detail.TvShow (
            60572,
            listOf(
                Detail.CreateBy(111776, "52fb6637c3a3682f251b5bdd", "Satoshi Tajiri", null),
                Detail.CreateBy(111778, "52fb66fe9251415a2a1b3d53", "Junichi Masuda", null),
                Detail.CreateBy(1292138, "52fb6656c3a36819b7370f5e", "Ken Sugimori", null)
            )as ArrayList<Detail.CreateBy>,
            "/tvjCdVRkaaab2ezM9BctkAOXeyW.jpg",
            "Pokémon",
            "Join Ash Ketchum, accompanied by his partner Pikachu, as he travels through many regions, meets new friends and faces new challenges on his quest to become a Pokémon Master.",
            "/rOuGm07PxBhEsK9TaGPRQVJQm1X.jpg",
            "1997-04-01",
            6.8
        ))

        return detail
    }

}

