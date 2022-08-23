package com.enes.kar.mvvm.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enes.kar.mvvm.data.model.response.DetailResponse
import com.enes.kar.mvvm.ui.base.BaseViewModel
import com.enes.kar.mvvm.util.AppConstants
import com.enes.kar.mvvm.util.Resource
import com.enes.kar.mvvm.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by M.Enes on 5.06.2022.
 */
@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepository): BaseViewModel() {

    val detail: MutableLiveData<DetailResponse?> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()

    fun getDetails(imdbId: String){
        if (imdbId.isEmpty()) return
        viewModelScope.launch {
            displayLoader(true)
            val response = detailRepository.detail(imdbId,AppConstants.API_KEY)
            response.let {
                displayLoader(false)
                when(response.status){
                    Status.SUCCESS ->{
                        detail.postValue(it.data)
                    }
                    Status.ERROR ->{
                        errorMessage.postValue(response.message?:"Error")
                    }
                }
            }
        }
    }
}