package com.enes.kar.mvvm.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.enes.kar.mvvm.BR
import com.enes.kar.mvvm.R
import com.enes.kar.mvvm.databinding.FragmentDetailBinding
import com.enes.kar.mvvm.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by M.Enes on 5.06.2022.
 */
@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding,DetailViewModel>() {

    private val detailViewModel: DetailViewModel by viewModels()

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail
    }

    override fun getViewModel(): DetailViewModel {
        return detailViewModel
    }

    override fun init(viewBinding: ViewBinding) {
        getViewDataBinding().activity = getBaseActivity()
        observers()
        arguments?.getString("id")?.let {
            detailViewModel.getDetails(it)
        }
    }

    private fun observers(){
        getViewModel().loader.observe(viewLifecycleOwner){
            if (it){
                getViewDataBinding().detailProgressBar.visibility = View.VISIBLE
            }else{
                getViewDataBinding().detailProgressBar.visibility = View.GONE
            }
        }
    }
}