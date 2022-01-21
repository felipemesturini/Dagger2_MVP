package com.example.dagger2lab001

import android.app.Application
import com.example.dagger2lab001.di.AppGraph
import com.example.dagger2lab001.di.DaggerAppGraph
import com.example.dagger2lab001.repository.CarRepositoryImpl

class CarApplication : Application() {
    lateinit var _appGraph: AppGraph

    override fun onCreate() {
        super.onCreate()
        _appGraph = DaggerAppGraph
            .factory()
            .repository(CarRepositoryImpl())
    }

    val appGraph: AppGraph
        get() = _appGraph

}
