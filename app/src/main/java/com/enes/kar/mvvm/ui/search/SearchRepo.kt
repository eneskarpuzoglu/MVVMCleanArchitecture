package com.enes.kar.mvvm.ui.search

import com.enes.kar.mvvm.data.model.response.SearchResponse
import com.enes.kar.mvvm.util.Resource

/**
 * Created by M.Enes on 6.06.2022.
 */
interface SearchRepo {

    suspend fun search(searchText: String): Resource<SearchResponse>
}