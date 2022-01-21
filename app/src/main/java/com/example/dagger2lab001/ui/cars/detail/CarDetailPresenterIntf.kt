package com.example.dagger2lab001.ui.cars.detail

import com.example.dagger2lab001.model.Car
import com.example.dagger2lab001.presenter.PresenterIntf

interface CarDetailPresenterIntf: PresenterIntf<Car, CarDetailCustomView> {
    fun handlerShowCar(id: Long)
}