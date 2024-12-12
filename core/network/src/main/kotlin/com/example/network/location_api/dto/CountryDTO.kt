package com.example.network.location_api.dto


import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("ID")
    val id: String? = null,
    @SerializedName("LocalizedName")
    val localizedName: String? = null
)