package com.example.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.example.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.example.forecastmvvm.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.example.forecastmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    //Funcion que actualiza o ingresa Update o insert
    //Se pone el onConflict por que definimos el ID 0 para todas las tomas del clima debtri de la BD
    //En la llave primaria
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry:CurrentWeatherEntry)

    @Query("SELECT * FROM current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("SELECT * FROM current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}