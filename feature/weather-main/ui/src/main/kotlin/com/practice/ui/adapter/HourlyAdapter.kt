package com.practice.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.practice.ui.model.HourlyUi
import com.practice.ui.databinding.ItemTimeWeatherBinding
import com.practice.ui.model.HourlyItem

class HourlyAdapter : ListAdapter<HourlyItem,HourlyViewHolder>(HourlyDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val binding = ItemTimeWeatherBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HourlyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HourlyViewHolder(private val binding: ItemTimeWeatherBinding) : ViewHolder(binding.root) {

    fun bind(data : HourlyItem) {
        with(binding) {
            timeTextView.text = data.time
            humidityTextView.text = data.humidity
            temperatureTextView.text = data.temperature
        }
    }
}

private class HourlyDiffCallBack : DiffUtil.ItemCallback<HourlyItem>() {
    override fun areItemsTheSame(oldItem: HourlyItem, newItem: HourlyItem): Boolean =
        //oldItem.time == newItem.time
        false

    override fun areContentsTheSame(oldItem: HourlyItem, newItem: HourlyItem): Boolean =
        // oldItem == newItem
        false
}