package com.example.settings

import android.content.Context
import androidx.navigation.NavController
import com.example.api.NavigationApi
import javax.inject.Inject

class PopMenuInstanceFactory @Inject constructor(
    private val context: Context,
    private val navApi: NavigationApi
) {
    fun create(navController: NavController): PopMenuInstance {
        return PopMenuInstance(context, navController, navApi)
    }
}
