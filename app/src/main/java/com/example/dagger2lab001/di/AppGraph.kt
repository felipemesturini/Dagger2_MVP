package com.example.dagger2lab001.di

import com.example.dagger2lab001.repository.RepositoryIntf
import com.example.dagger2lab001.ui.cars.detail.CarDetailFragment
import com.example.dagger2lab001.ui.cars.list.CarListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppGraph {
    fun inject(fragment: CarListFragment)
    fun inject(fragment: CarDetailFragment)

    @Component.Factory
    interface Factory {
        fun repository(@BindsInstance repository: RepositoryIntf): AppGraph
    }

}