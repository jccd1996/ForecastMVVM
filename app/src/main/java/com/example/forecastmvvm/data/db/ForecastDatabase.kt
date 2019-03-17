package com.example.forecastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forecastmvvm.data.db.entity.CurrentWeatherEntry

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1

)
abstract class ForecastDatabase:RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    //Singleton es para no crear muchos objetos al mismo tiempo
    companion object {
        @Volatile  private  var instance : ForecastDatabase? = null
        //Asegura que ninguna tarea trabaje al mismo tiempo
        private val LOCK= Any()

        //si el operador no es nulo se sincroniza
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDataBase(context).also { instance= it }
        }

        private fun buildDataBase(context: Context)=
                Room.databaseBuilder(context.applicationContext,
                    ForecastDatabase::class.java, "forecast.db")
                    .build()
    }
}