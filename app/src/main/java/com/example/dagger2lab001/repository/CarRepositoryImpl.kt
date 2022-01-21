package com.example.dagger2lab001.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.dagger2lab001.model.Car

class CarRepositoryImpl: RepositoryIntf {

    private val mCarsMap = mutableMapOf<Long, Car>()

    init {
        (1..10000).map { it.toLong() }.forEach {
            insert(
                Car(
                    "Car number ${it}",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                            " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                            "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                            "culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis " +
                            "iste natus error sit voluptatem accusantium doloremque laudantium, totam rem " +
                            "aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae " +
                            "vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur " +
                            "aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem " +
                            "sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, " +
                            "consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut " +
                            "labore et dolore magnam aliquam quaerat voluptatem."
                )
            )
        }
    }

    override fun find(id: Long): Car? {
        return mCarsMap.get(id)
    }

    override fun list(): List<Car> {
        return mCarsMap.values.toList()
    }

    override fun insert(car: Car) {
        mCarsMap.put(car.title.hashCode().toLong(), car)
    }

}