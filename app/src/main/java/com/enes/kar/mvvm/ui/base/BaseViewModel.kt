package com.enes.kar.mvvm.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by M.Enes on 4.06.2022.
 */
open class BaseViewModel(): ViewModel() {

    val loader: MutableLiveData<Boolean> = MutableLiveData()


    fun displayLoader(isLoading: Boolean) {
        loader.value = isLoading
    }

}