package com.enes.kar.mvvm.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.enes.kar.mvvm.BR
import com.enes.kar.mvvm.data.model.SearchResultModel
import com.enes.kar.mvvm.databinding.ItemSearchBinding
import com.enes.kar.mvvm.util.DataBindingViewHolder

/**
 * Created by M.Enes on 4.06.2022.
 */
class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private var onItemClickListener: ((String) -> Unit)? = null

    private val diffCallback = object : DiffUtil.ItemCallback<SearchResultModel>() {
        override fun areItemsTheSame(oldItem: SearchResultModel, newItem: SearchResultModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SearchResultModel, newItem: SearchResultModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var results: List<SearchResultModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    inner class ViewHolder(binding: ViewDataBinding): DataBindingViewHolder<SearchResultModel>(binding){
        override fun onBind(t: SearchResultModel, position: Int) {
            dataBinding.setVariable(BR.item,t)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(results[position],position)
        val imdbId = results[position].imdbID
        imdbId?.let {
            holder.itemView.apply {
                setOnClickListener {
                    onItemClickListener?.let { click ->
                        click(imdbId)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = results.size


    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }
}