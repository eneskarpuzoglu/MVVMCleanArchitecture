package com.enes.kar.mvvm.data.remote

import com.enes.kar.mvvm.data.model.response.DetailResponse
import com.enes.kar.mvvm.data.model.response.SearchResponse
import com.enes.kar.mvvm.util.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
* Created by M.Enes on 4.06.2022.
*/
interface ApiService {

    @GET(".")
    suspend fun search(@Query("s")s: String, @Query("apiKey")apiKey: String = AppConstants.API_KEY): Response<SearchResponse>


    @GET(".")
    suspend fun detail(@Query("i") i: String,@Query("apiKey") apiKey: String = AppConstants.API_KEY): Response<DetailResponse>
}