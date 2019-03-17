package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo


//No son entidades(tablas), pero son clases que toman valores de nuestra BD
data class ImperialCurrentWeatherEntry(

    //Con la anotacion ColumnInfo, toma el valor que se encuentra en la tabla
    //de La base de datos CurrentEntryWeather
    @ColumnInfo(name = "tempF")
    override val temperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "windMph")
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precipIn")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslikeF")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visMiles")
    override val visibilityDistance: Double

) : UnitSpecificCurrentWeatherEntry