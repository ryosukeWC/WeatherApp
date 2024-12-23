package com.example.impl

import com.example.api.NavData
import com.example.api.NavigationApi

class NavigationApiImpl(

) : NavigationApi {

    override fun actionToCitiesSearch(): NavData {
        return NavData() // как мне импортировать ресурсы из другого модуля
    }

}