package com.example.dagger2lab001.ui.cars.detail

import com.example.dagger2lab001.model.Car
import com.example.dagger2lab001.presenter.CustomView

interface CarDetailCustomView: CustomView<Car> {
    fun showCar(car: Car)
}