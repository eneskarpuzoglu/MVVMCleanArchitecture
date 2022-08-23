package com.enes.kar.mvvm.ui.search

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.enes.kar.mvvm.BR
import com.enes.kar.mvvm.R
import com.enes.kar.mvvm.data.model.SearchResultModel
import com.enes.kar.mvvm.databinding.FragmentSearchBinding
import com.enes.kar.mvvm.ui.base.BaseFragment
import com.enes.kar.mvvm.ui.search.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by M.Enes on 4.06.2022.
 */
@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding,SearchViewModel>() {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }

    override fun getViewModel(): SearchViewModel {
        return searchViewModel
    }

    override fun init(viewBinding: ViewBinding) {
        searchViewModel.searchAdapter.setOnItemClickListener {
            Navigation.findNavController(requireActivity(), R.id.home_fragment)
                .navigate(SearchFragmentDirections.actionSearchToDetail(it))
        }
        observers()

    }

    private fun observers(){
        searchViewModel.loader.observe(viewLifecycleOwner){ visible ->
            if (visible){
                getViewDataBinding().searchProgressBar.visibility = View.VISIBLE
            }else{
                getViewDataBinding().searchProgressBar.visibility = View.GONE
            }
        }
        searchViewModel.errorMessage.observe(viewLifecycleOwner){ message ->
            Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
        }

        searchViewModel.searchResults.observe(viewLifecycleOwner){ results ->
            searchViewModel.searchAdapter.results = results
        }
    }
}