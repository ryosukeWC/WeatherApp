package com.example.impl

import com.example.api.NavData
import com.example.api.NavigationApi
//import com.practice.weather.city_search.R
import javax.inject.Inject
import javax.inject.Singleton


class NavigationApiImpl @Inject constructor() : NavigationApi {

    override fun actionToCitiesSearch(): NavData {
        return NavData(R.id.action_homeScreen_to_citiesSearchFragment2)
    }

}