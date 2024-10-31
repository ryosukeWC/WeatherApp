package com.practice.location

import android.location.Location

interface LocationTracker {

    suspend fun getCurrentLocation() : Location?

    class LocationException(message : String)

}