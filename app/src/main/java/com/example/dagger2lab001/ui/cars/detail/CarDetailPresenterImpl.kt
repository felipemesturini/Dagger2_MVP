package com.example.dagger2lab001.ui.cars.detail

import android.util.Log
import com.example.dagger2lab001.model.Car
import com.example.dagger2lab001.presenter.BasePresenter
import com.example.dagger2lab001.repository.RepositoryIntf
import javax.inject.Inject
import javax.inject.Scope

class CarDetailPresenterImpl @Inject constructor(
    private val repository: RepositoryIntf
): BasePresenter<Car, CarDetailCustomView>(), CarDetailPresenterIntf {
    override fun handlerShowCar(id: Long) {
        Log.i("CarDetailPresenterImpl", "Find car details here")
       repository.find(id)?.let {
           view?.showCar(it)
       }
    }
}