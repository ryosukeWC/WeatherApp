package com.practice.ui.view

import android.Manifest
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.settings.PopMenuInstance
import com.example.settings.PopMenuInstanceFactory
import com.practice.ui.logic.State
import com.practice.ui.adapter.HourlyAdapter
import com.practice.ui.logic.viewmodel.HomeScreenViewModel
import com.practice.ui.databinding.HomeFragmentBinding
import com.practice.ui.logic.model.WeatherDataUi
import com.practice.ui.logic.toListHourlyItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeScreen : Fragment() {

    @Inject
    lateinit var popUpMenuInstanceFactory : PopMenuInstanceFactory

    companion object {
        fun newInstance() = HomeScreen()
    }

    private val viewModel: HomeScreenViewModel by viewModels()

    private lateinit var binding : HomeFragmentBinding

    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.fetchData()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))

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

//                        is State.Loading -> {
//                             буду показывать shimmer placeholder
//                        }

                        is State.Success -> {

                            val data = state.data
                            bindUi(data)
                            val test = data.hourlyUi.toListHourlyItem()
                            hourlyAdapter.submitList(test)
                        }

//                        is State.Error -> {
//                            // буду показывать диалог с ошибкой
//                        }

                        else -> {} // функция для перехода на экран ошибки
                    }
                }
            }
        }

        val navController = findNavController()

        val popUpInstance = popUpMenuInstanceFactory.create(navController)

        binding.settingsButton.setOnClickListener {
            popUpInstance.showPopUpMenu(binding.root)
        }
    }

    private fun bindUi(dataUi: WeatherDataUi) {
        binding.currentTemperature.text = dataUi.currentUi.temperature2m.toString()
    }
    private fun selectMainCardBackground() {

    }
}