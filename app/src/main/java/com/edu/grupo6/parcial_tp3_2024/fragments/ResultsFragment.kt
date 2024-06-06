package com.edu.grupo6.parcial_tp3_2024.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edu.grupo6.parcial_tp3_2024.R
import com.edu.grupo6.parcial_tp3_2024.adapters.FlightAdapter
import com.edu.grupo6.parcial_tp3_2024.model.Flight

class ResultsFragment : Fragment() {

    lateinit var view1: View
    lateinit var recFlights: RecyclerView
    private var flightList : MutableList<Flight> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onStart(){
        super.onStart()

        flightList.add(Flight("United Airlines", "01 hr 40min", "EZE", "Ezeiza Ar", "LAX", "Los Angles", "Business Class", "$1128"))
        flightList.add(Flight("United Airlines", "02 hr 10min", "EZE", "Ezeiza Ar", "LAX", "Los Angles", "Business Class", "$1420"))
        flightList.add(Flight("Asia Airlines", "02 hr 38min", "EZE", "Ezeiza Ar", "LAX", "Los Angles", "Business Class", "$1550"))
        flightList.add(Flight("Lufthansa Airlines", "03 hr 15min", "EZE", "Ezeiza Ar", "LAX", "Los Angeles", "Business Class", "$1650"))

        recFlights = view1.findViewById(R.id.rec_search_results)
        recFlights.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)
        val flightAdapter = FlightAdapter(flightList)

        recFlights.layoutManager = linearLayoutManager
        recFlights.adapter = flightAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.fragment_search_results, container, false)

        return view1
    }

}