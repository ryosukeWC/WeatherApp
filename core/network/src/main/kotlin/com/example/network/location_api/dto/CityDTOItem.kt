package com.example.network.location_api.dto


import com.google.gson.annotations.SerializedName

data class CityDTOItem(
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeAreaDTO? = null,
    @SerializedName("Country")
    val country: CountryDTO? = null,
    @SerializedName("Key")
    val key: String? = null,
    @SerializedName("LocalizedName")
    val localizedName: String? = null,
    @SerializedName("Rank")
    val rank: Int? = null,
    @SerializedName("Type")
    val type: String? = null,
    @SerializedName("Version")
    val version: Int? = null
)