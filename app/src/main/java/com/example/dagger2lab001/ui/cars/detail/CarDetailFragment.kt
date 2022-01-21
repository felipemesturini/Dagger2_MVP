package com.example.dagger2lab001.ui.cars.detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dagger2lab001.CarApplication
import com.example.dagger2lab001.R
import com.example.dagger2lab001.model.Car
import javax.inject.Inject


class CarDetailFragment : Fragment(), CarDetailCustomView {
    // TODO: Rename and change types of parameters
    private var param1: Long? = null
    private lateinit var mTitleTextView: TextView
    private lateinit var mDetailTextView: TextView

    @Inject
    lateinit var mCarDetailPresenter: CarDetailPresenterIntf

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getLong(PARAM_CAR_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTitleTextView = view.findViewById(R.id.titleTetView)
        mDetailTextView = view.findViewById(R.id.detailTextView)
    }

    override fun onAttach(context: Context) {
        (context.applicationContext as CarApplication).appGraph.inject(this)
        mCarDetailPresenter.bind(this)
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
        param1?.let {
            mCarDetailPresenter.handlerShowCar(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCarDetailPresenter.unbind()
    }

    companion object {
        const val PARAM_CAR_ID = "car_id"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param buble Parametre to passed
         * @return A new instance of fragment CarDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(bundle: Bundle) =
            CarDetailFragment().apply {
                arguments = bundle
            }
    }

    override fun showCar(car: Car) {
        Log.i("CarDetailFragment", car.toString())
        mTitleTextView.text = car.title
        mDetailTextView.text = car.details
    }
}