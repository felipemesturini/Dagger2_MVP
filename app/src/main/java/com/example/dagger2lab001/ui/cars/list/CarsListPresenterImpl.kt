package com.example.dagger2lab001.ui.cars.list

import android.util.Log
import com.example.dagger2lab001.model.Car
import com.example.dagger2lab001.model.CarsList
import com.example.dagger2lab001.presenter.BasePresenter
import com.example.dagger2lab001.repository.RepositoryIntf
import javax.inject.Inject

class CarsListPresenterImpl @Inject constructor(
    private val repository: RepositoryIntf)
    : BasePresenter<CarsList, CarListCustomView>(), CarsListPresenterIntf {

    override fun showCars() {
        Log.i("CarsListPresenterImpl", "List From Presentes")
        val newList = repository.list()
        view?.handleResult(CarsList(newList))
    }

}