package com.example.impl

import com.example.api.NavData
import com.example.api.NavigationApi
import com.practice.weather.city_search.R

class NavigationApiImpl(

) : NavigationApi {

    override fun actionToCitiesSearch(): NavData {
        return NavData(R.id.action_citiesSearchFragment_self)
    }

}