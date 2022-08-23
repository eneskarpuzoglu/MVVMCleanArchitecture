package com.enes.kar.mvvm.ui.search

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enes.kar.mvvm.data.model.SearchResultModel
import com.enes.kar.mvvm.ui.base.BaseViewModel
import com.enes.kar.mvvm.ui.search.adapter.SearchAdapter
import com.enes.kar.mvvm.util.AppConstants
import com.enes.kar.mvvm.util.Extensions.hideKeyboard
import com.enes.kar.mvvm.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by M.Enes on 4.06.2022.
 */
@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository): BaseViewModel() {


    var searchText = MutableLiveData<String>()
    val searchResults = MutableLiveData<List<SearchResultModel>>(emptyList())
    val errorMessage = MutableLiveData<String>()
    val searchAdapter = SearchAdapter()

    val editorActionListener = TextView.OnEditorActionListener{ v, action, _ ->
        if (action == EditorInfo.IME_ACTION_SEARCH){
            search(v)
            true
        }else false
    }

    fun search(view: View){
        if (isSearchTextEmpty()) return
        view.context.hideKeyboard(view)
        viewModelScope.launch{
            displayLoader(true)
            val response = searchRepository.search(searchText.value!!)
            response.let {
                when(response.status){
                    Status.SUCCESS -> {
                        response.data?.search?.let { results ->
                            searchResults.postValue(results)
                        }
                    }
                    Status.ERROR -> {
                        errorMessage.postValue(response.message?:"Error")
                    }
                }
                displayLoader(false)
            }
        }
    }

    fun clearEditText(){
        searchText.postValue("")
    }

    private fun isSearchTextEmpty(): Boolean{
        return searchText.value?.isEmpty() ?: false
    }
}