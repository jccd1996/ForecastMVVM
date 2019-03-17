package com.example.forecastmvvm.data.db.network.response


import com.example.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.example.forecastmvvm.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    //Se pone SerializedName por que asi viene en el JSONObject, como current
    //pero en el codigo se usara currentEntryWeather para evitar conflictos
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)