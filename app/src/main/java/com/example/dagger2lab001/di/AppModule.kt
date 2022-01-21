package com.example.dagger2lab001.di

import com.example.dagger2lab001.ui.cars.detail.CarDetailPresenterImpl
import com.example.dagger2lab001.ui.cars.detail.CarDetailPresenterIntf
import com.example.dagger2lab001.ui.cars.list.CarsListPresenterImpl
import com.example.dagger2lab001.ui.cars.list.CarsListPresenterIntf
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideCarListPresenter(repository: CarsListPresenterImpl): CarsListPresenterIntf

    @Binds
    abstract fun provideCarDetailPresenter(repository: CarDetailPresenterImpl): CarDetailPresenterIntf
}