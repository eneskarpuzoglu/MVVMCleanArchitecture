package com.enes.kar.mvvm.data.model.response

import com.enes.kar.mvvm.data.model.SearchResultModel
import com.google.gson.annotations.SerializedName

/**
 * Created by M.Enes on 4.06.2022.
 */
data class SearchResponse(
    @SerializedName("Search")
    var search: List<SearchResultModel>?,
    @SerializedName("Error")
    var error:String?)