package com.example.dagger2lab001.ui.cars.list

import com.example.dagger2lab001.model.CarsList
import com.example.dagger2lab001.presenter.PresenterIntf

interface CarsListPresenterIntf: PresenterIntf<CarsList, CarListCustomView> {
    fun showCars()
}