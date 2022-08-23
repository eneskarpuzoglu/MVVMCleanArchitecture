package com.enes.kar.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by M.Enes on 4.06.2022.
 */
data class SearchResultModel(
    @SerializedName("Title")
    var title: String? = null,
    @SerializedName("Year")
    var year: String? = null,
    @SerializedName("imdbID")
    var imdbID: String? = null,
    @SerializedName("Type")
    var type: String? = null,
    @SerializedName("Poster")
    var poster: String? = null,
)