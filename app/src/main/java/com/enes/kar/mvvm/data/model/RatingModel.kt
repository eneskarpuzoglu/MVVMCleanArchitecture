package com.enes.kar.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by M.Enes on 4.06.2022.
 */
data class RatingModel(
    @SerializedName("Source")
    var source: String? = null,
    @SerializedName("Value")
    var value: String? = null)