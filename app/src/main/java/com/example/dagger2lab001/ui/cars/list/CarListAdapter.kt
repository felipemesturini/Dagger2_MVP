package com.example.dagger2lab001.ui.cars.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2lab001.R
import com.example.dagger2lab001.model.Car
import com.example.dagger2lab001.model.CarsList

typealias OnViewHolderItemClick<T> = (T) -> Unit

class CarListAdapter(
    private val data: CarsList,
    private val handler: OnViewHolderItemClick<Car?>
): RecyclerView.Adapter<CarListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_list_item_row, parent, false)
        return CarListItemViewHolder(itemView, handler )
    }

    override fun getItemCount() = data.list.size

    override fun onBindViewHolder(holder: CarListItemViewHolder, position: Int) {
        holder.bind(data.list[position])
    }
}