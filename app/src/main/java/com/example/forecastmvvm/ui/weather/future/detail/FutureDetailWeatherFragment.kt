package com.example.forecastmvvm.ui.weather.future.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.forecastmvvm.R

class FutureDetailWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureDetailWeatherFragment()
    }

    private lateinit var viewModelDetail: FutureDetailWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_detail_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelDetail = ViewModelProviders.of(this).get(FutureDetailWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
