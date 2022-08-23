package com.enes.kar.mvvm.ui.home

import com.enes.kar.mvvm.data.local.PreferencesHelper
import com.enes.kar.mvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by M.Enes on 4.06.2022.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(homeRepository: HomeRepository,private val preferencesHelper: PreferencesHelper): BaseViewModel() {
}