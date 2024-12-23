package com.practice.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.ui.view.HomeScreen
import com.practice.weather.city_search.CitiesSearchFragment
import com.practice.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id,CitiesSearchFragment.newInstance()).commit()
    }
}