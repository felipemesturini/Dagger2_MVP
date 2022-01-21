package com.example.dagger2lab001.ui.cars.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2lab001.R
import com.example.dagger2lab001.model.Car

class CarListItemViewHolder(
    itemView: View,
    handler: OnViewHolderItemClick<Car?>?
    ) : RecyclerView.ViewHolder(itemView) {
        private val mTitle = itemView.findViewById<TextView>(R.id.carTtileTextView)
        private val mDetail = itemView.findViewById<TextView>(R.id.carDetailTextView)
        private var currentCar: Car? = null

    init {
        itemView.setOnClickListener {
            handler?.let {
                it(currentCar)
            }
        }
    }

    fun bind(car: Car) {
        this.currentCar = car
        car.run {
            mTitle.text = title
            mDetail.text = details
        }
    }
}