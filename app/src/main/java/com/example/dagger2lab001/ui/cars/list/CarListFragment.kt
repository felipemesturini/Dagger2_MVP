package com.example.dagger2lab001.ui.cars.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2lab001.CarApplication
import com.example.dagger2lab001.R
import com.example.dagger2lab001.model.CarsList
import com.example.dagger2lab001.ui.cars.detail.CarDetailFragment
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CarListFragment : Fragment(), CarListCustomView {
    private var param1: String? = null
    private var param2: String? = null
    private val mListOfCars = CarsList(emptyList())
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mCarListAdapter: CarListAdapter

    @Inject
    lateinit var mCarCarsListPresenter: CarsListPresenterIntf

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        mCarCarsListPresenter.showCars()

    }

    override fun onDestroy() {
        super.onDestroy()
        mCarCarsListPresenter.unbind()
    }

    override fun onAttach(context: Context) {
        //Inject dagger components
        (activity?.applicationContext as CarApplication).appGraph.inject(this)
//        mCarCarsListPresenter = CarsListPresenterImpl() //Substituir pelo dagger
        mCarCarsListPresenter.bind(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerList)
        mRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val itemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        mRecyclerView.addItemDecoration(itemDecoration)
        mCarListAdapter = CarListAdapter(mListOfCars) {
            Log.i("CarListFragment", it.toString())
            val bundle = Bundle().apply {
                putLong(CarDetailFragment.PARAM_CAR_ID, it?.id ?: -1)
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerLayout, CarDetailFragment.newInstance(bundle))
                .addToBackStack("carDetail")
                .commit()

        }
        mRecyclerView.adapter = mCarListAdapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CarListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, "param1")
                    putString(ARG_PARAM2, "param2")
                }
            }
    }

    override fun handleResult(carstList: CarsList) {
        mListOfCars.list = carstList.list
        mCarListAdapter.notifyDataSetChanged()
    }
}