package com.practice.weather.city_search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.practice.weather.city_search.R
import com.practice.weather.city_search.databinding.ItemCityBinding
import com.practice.weather.data.model.location.CityItem

class CitiesAdapter : ListAdapter<CityItem,CityViewHolder>(CityDiffCallback()) {

    private lateinit var binding: ItemCityBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        binding = ItemCityBinding.bind(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false))

        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CityViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(city: CityItem) {
        binding.nameCityTextView.text = "${city.localizedName}, ${city.administrativeArea?.localizedName}, ${city.country?.localizedName}"
    }
}

class CityDiffCallback : DiffUtil.ItemCallback<CityItem>() {
    override fun areItemsTheSame(oldItem: CityItem, newItem: CityItem): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: CityItem, newItem: CityItem): Boolean {
        return oldItem == newItem
    }
}
