package com.example.dagger2lab001.repository

import com.example.dagger2lab001.model.Car

interface RepositoryIntf {

    fun find(id: Long): Car?

    fun list(): List<Car>

    fun insert(car: Car)

    fun insert(cars: List<Car>) = cars.forEach { this.insert(it) }
}