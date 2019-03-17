package com.example.forecastmvvm.data

import com.example.forecastmvvm.data.db.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY="5c2ec22063c64eadac705015191703"

//http://api.apixu.com/v1/current.json?key=5c2ec22063c64eadac705015191703&q=ibague&lang=es

interface ApixuWeatherApiService {

    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") location : String,
        @Query("lang") languageCode: String = "es"
    ):Deferred <CurrentWeatherResponse> // esta parte define el trabajo asyncrono de la app
                                        // Cuando este lista la tarea, se puede seguir trabajando

    companion object {
        operator fun invoke():ApixuWeatherApiService{
            //Cuando un parametro se usa tanto como la key de una api, se debe
            //crear un interceptor como se hace a continuacion
            val requestInterceptor=Interceptor{chain->

                val url=chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }
            val okHttpClient=OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }
}