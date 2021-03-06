package com.meals.school_food.widget.adapter

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.meals.school_food.BR

data class RecyclerItem(
        val viewModel: Any,
        val navigator: Any,
        @LayoutRes val layoutId: Int
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.navigator, navigator)
    }
}