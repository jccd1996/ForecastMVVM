package com.example.forecastmvvm.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0
//Entidad es igual a tabla
//El problema de SQLite es que no puede guardar clases custom como Condition
//En cambio si puede guardar int,doubles,etc..
@Entity(tableName = "current_weather")

data class CurrentWeatherEntry(
    //Se puede borrar lo que no se necesita, es seguro
    @Embedded(prefix="condition_")
    val condition: Condition,
    @SerializedName("feelslike_c")
    val feelslikeC: Double,
    @SerializedName("feelslike_f")
    val feelslikeF: Double,
    @SerializedName("gust_kph")
    val gustKph: Double,
    @SerializedName("gust_mph")
    val gustMph: Double,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int,
    @SerializedName("precip_in")
    val precipIn: Double,
    @SerializedName("precip_mm")
    val precipMm: Double,
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("temp_f")
    val tempF: Double,
    val uv: Double,
    @SerializedName("vis_km")
    val visKm: Double,
    @SerializedName("vis_miles")
    val visMiles: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("wind_mph")
    val windMph: Double
){
    @PrimaryKey(autoGenerate = false)
    var id:Int= CURRENT_WEATHER_ID
}