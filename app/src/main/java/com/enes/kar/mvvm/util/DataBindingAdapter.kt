package com.enes.kar.mvvm.util

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.enes.kar.mvvm.R
import com.enes.kar.mvvm.ui.search.SearchViewModel

/**
 * Created by M.Enes on 4.06.2022.
 */
object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("image_url")
    fun imageUrl(imageView: ImageView, url: String?){
        if (url == null) { return }
        imageView.load(url){
            placeholder(R.color.gray)
            error(R.color.gray)
            scale(Scale.FILL)
        }
    }

    @JvmStatic
    @BindingAdapter("onEditorActionListener")
    fun onEditorActionListener(editText: EditText, editorActionListener: TextView.OnEditorActionListener){
        editText.setOnEditorActionListener(editorActionListener)
    }
}