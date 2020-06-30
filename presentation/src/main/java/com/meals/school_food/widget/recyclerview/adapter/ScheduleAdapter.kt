package com.meals.school_food.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.meals.domain.model.DetailSchedule
import com.meals.domain.model.SchoolInformation
import com.meals.school_food.R
import com.meals.school_food.databinding.ItemScheduleBinding
import com.meals.school_food.databinding.ItemSchoolBinding
import com.meals.school_food.widget.recyclerview.viewmodel.ScheduleItemViewModel
import com.meals.school_food.widget.recyclerview.viewmodel.SchoolItemViewModel

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){

    private lateinit var scheduleList : ArrayList<DetailSchedule>

    fun setList(list : ArrayList<DetailSchedule>) {
        if(::scheduleList.isInitialized) return
        scheduleList = list
    }

    class ViewHolder(private val binding : ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ScheduleItemViewModel()

        fun bind(schedule : DetailSchedule) {
            viewModel.bind(schedule)
            binding.viewModel = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_schedule,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return if(::scheduleList.isInitialized) scheduleList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(scheduleList[position])
    }
}