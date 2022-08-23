package com.enes.kar.mvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.enes.kar.mvvm.R
import com.enes.kar.mvvm.BR
import com.enes.kar.mvvm.databinding.ActivityHomeBinding
import com.enes.kar.mvvm.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by M.Enes on 4.06.2022.
 */
@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding,HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): HomeViewModel {
        return homeViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}