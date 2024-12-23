package com.practice.weather.city_search

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.weather.city_search.adapter.CitiesAdapter
import com.practice.weather.city_search.databinding.FragmentCitiesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CitiesSearchFragment : Fragment() {

    private lateinit var binding: FragmentCitiesBinding

    companion object {
        fun newInstance() = CitiesSearchFragment()
    }

    private val viewModel: CitiesSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.citiesRecyclerView
        val citiesAdapter = CitiesAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = citiesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.citiesState.collect { cityItems ->
                citiesAdapter.submitList(cityItems)
            }
        }

//        binding.searchView.setOnQueryTextFocusChangeListener { view, bool ->
//            when (bool) {
//                true -> {
//
//                }
//                false -> {
//
//                }
//            }
//        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText != null) {
                    viewModel.fetchCities(newText)
                }
                return true
            }

        })
    }
}