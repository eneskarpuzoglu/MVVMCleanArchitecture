package com.enes.kar.mvvm.data.model.response

import com.enes.kar.mvvm.data.model.RatingModel
import com.google.gson.annotations.SerializedName

/**
 * Created by M.Enes on 4.06.2022.
 */
data class DetailResponse(
    @SerializedName("Title")
    var title:String?,
    @SerializedName("Year")
    var year:String?,
    @SerializedName("Released")
    var released:String?,
    @SerializedName("Runtime")
    var runtime:String?,
    @SerializedName("Genre")
    var genre:String?,
    @SerializedName("Director")
    var director:String?,
    @SerializedName("Writer")
    var writer:String?,
    @SerializedName("Actors")
    var actors:String?,
    @SerializedName("Plot")
    var plot:String?,
    @SerializedName("Language")
    var language:String?,
    @SerializedName("Country")
    var country:String?,
    @SerializedName("Awards")
    var awards:String?,
    @SerializedName("Metascore")
    var metascore:String?,
    @SerializedName("imdbRating")
    var imdbRating:String?,
    @SerializedName("imdbVotes")
    var imdbVotes:String?,
    @SerializedName("imdbID")
    var imdbID:String?,
    @SerializedName("Type")
    var type:String?,
    @SerializedName("DVD")
    var dvd:String?,
    @SerializedName("BoxOffice")
    var boxOffice:String?,
    @SerializedName("Poster")
    var poster:String?,
    @SerializedName("Production")
    var production:String?,
    @SerializedName("Website")
    var website:String?,
    @SerializedName("Response")
    var response:String?,
    @SerializedName("Ratings")
    var ratings:List<RatingModel>?
)