package com.practice.ui.view

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.practice.location.LocationProvider
import com.practice.ui.State
import com.practice.ui.adapter.HourlyAdapter
import com.practice.ui.viewmodel.HomeScreenViewModel
import com.practice.ui.databinding.HomeFragmentBinding
import com.practice.ui.model.WeatherDataUi
import com.practice.ui.toListHourlyItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : Fragment() {

    companion object {
        fun newInstance() = HomeScreen()
    }

    private val viewModel: HomeScreenViewModel by viewModels()

    private lateinit var binding : HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
        // inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.timeRecyclerView

        val hourlyAdapter = HourlyAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = hourlyAdapter
            this.setHasFixedSize(true)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when (state) {
                        is State.Success -> {
                            val data = state.data
                            bindUi(data)
                            val test = data.hourlyUi.toListHourlyItem()
                            hourlyAdapter.submitList(test)
                        }
                        else -> {} // функция для перехода на экран ошибки
                    }
                }
            }
        }
        // реализовать model класс weatherData для ui

        val locationProvider = LocationProvider(requireContext())


        if (isLocationPermissionGranted()) {
            locationProvider.getLocation { location ->

                Log.d("longitude", location.longitude.toString())
                Log.d("latitude", location.latitude.toString())
            }
        }
        else {
            requestLocationPermission()
        }


    }

    private fun requestLocationPermission() {
        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()) { permission ->
            when (permission) {
                true -> println("Permission has been granted")
                false -> println("Permission has been denied")
            }
        }
        activityResultLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private fun isLocationPermissionGranted() : Boolean {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }




    private fun bindUi(dataUi: WeatherDataUi) {
        binding.currentTemperature.text = dataUi.currentUi.temperature2m.toString()
    }
}