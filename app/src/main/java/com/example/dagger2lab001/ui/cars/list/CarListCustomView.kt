package com.example.dagger2lab001.ui.cars.list

import com.example.dagger2lab001.model.CarsList
import com.example.dagger2lab001.presenter.CustomView

interface CarListCustomView: CustomView<CarsList>{
    fun handleResult(carstList: CarsList)
}