package com.practice.ui.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.practice.ui.State
import com.practice.ui.viewmodel.HomeScreenViewModel
import com.practice.ui.databinding.HomeFragmentBinding
import com.practice.ui.model.WeatherDataUi
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

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when (state) {
                        is State.Success -> bindUi(state.data)
                        else -> {} // функция для перехода на экран ошибки
                    }
                }
            }
        }
        // реализовать model класс weatherData для ui
    }

    private fun bindUi(dataUi: WeatherDataUi) {
        binding.currentTemperature.text = dataUi.currentUi.temperature2m.toString()
    }
}