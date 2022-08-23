package com.enes.kar.mvvm.ui.detail

import com.enes.kar.mvvm.data.model.response.DetailResponse
import com.enes.kar.mvvm.data.remote.ApiService
import com.enes.kar.mvvm.util.Resource
import javax.inject.Inject

/**
 * Created by M.Enes on 5.06.2022.
 */
class DetailRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun detail(i: String, apiKey: String): Resource<DetailResponse>{
        val response = apiService.detail(i,apiKey)
        return if (response.isSuccessful && response.body() != null){
            Resource.success(response.body()!!)
        }else Resource.error(response.message(),null)
    }
}