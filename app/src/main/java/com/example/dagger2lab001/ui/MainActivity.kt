package com.example.dagger2lab001.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dagger2lab001.R
import com.example.dagger2lab001.ui.cars.list.CarListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerLayout, CarListFragment.newInstance())
                .commit()
        }
    }
}