package com.enes.kar.mvvm.ui.search

import com.enes.kar.mvvm.data.model.response.SearchResponse
import com.enes.kar.mvvm.data.remote.ApiService
import com.enes.kar.mvvm.util.Resource
import javax.inject.Inject

/**
 * Created by M.Enes on 4.06.2022.
 */
open class SearchRepository @Inject constructor(private val apiService: ApiService) {

    open suspend fun search(searchText: String): Resource<SearchResponse> {
        val response = apiService.search(searchText)
        return try {
            if (response.isSuccessful && response.body() != null){
                Resource.success(response.body())
            }else{
                Resource.error(response.message(),null)
            }
        }catch (e: Exception){
            Resource.error("Couldn't reach the server. ${e.message}",null)
        }

    }
}