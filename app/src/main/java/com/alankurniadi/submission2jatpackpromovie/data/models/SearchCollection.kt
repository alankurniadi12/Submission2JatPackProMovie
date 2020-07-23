package com.alankurniadi.submission2jatpackpromovie.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchCollection (
    var id: Int,
    var name: String? = "",
    var poster_path: String? = ""
): Parcelable