package com.example.dagger2lab001.ui.cars.detail

import com.example.dagger2lab001.model.Car
import com.example.dagger2lab001.presenter.BasePresenter

class CarDetailPresenterImpl: BasePresenter<Car, CarDetailCustomView>(), CarDetailPresenterIntf {
    override fun handlerShowCar(id: Long) {
        val newList = listOf(
            Car("Corsa Super", "Corsa 1999 1.0 Super 4 bicos"),
            Car("Vectra Elegance", "Verctra 2002 2.0 Super"),
        )
        val item = newList.first()
        view?.showCar(item)
    }
}