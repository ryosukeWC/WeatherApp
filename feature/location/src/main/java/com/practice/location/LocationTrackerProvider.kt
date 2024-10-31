package com.practice.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationTrackerProvider(
    private val context: Context,
) : LocationTracker {

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Location? =

        withContext(Dispatchers.IO) {

            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

            return@withContext suspendCancellableCoroutine { continuation ->

                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location ->
                        continuation.resume(location)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }

            }
        }
}