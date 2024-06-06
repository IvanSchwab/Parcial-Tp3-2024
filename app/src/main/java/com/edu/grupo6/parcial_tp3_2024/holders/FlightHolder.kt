package com.edu.grupo6.parcial_tp3_2024.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edu.grupo6.parcial_tp3_2024.R

class FlightHolder(v: View): RecyclerView.ViewHolder(v) {

    private var view : View

    init {
        this.view = v
    }

    fun setAirlineName(airline: String?){
        val txt : TextView = view.findViewById(R.id.airlineName)
        txt.text = airline
    }

    fun setDuration(duration: String?){
        val txt : TextView = view.findViewById(R.id.totalDuration)
        txt.text = duration
    }

    fun setDepartureId(departureId: String?){
        val txt : TextView = view.findViewById(R.id.departureAirportId)
        txt.text = departureId
    }

    fun setDepartureName(departureName: String?){
        val txt : TextView = view.findViewById(R.id.departureAirportName)
        txt.text = departureName
    }

    fun setArrivalId(arrivalId: String?){
        val txt : TextView = view.findViewById(R.id.arrivalAirportId)
        txt.text = arrivalId
    }

    fun setArrivalName(arrivalName: String?){
        val txt : TextView = view.findViewById(R.id.arrivalAirportName)
        txt.text = arrivalName
    }

    fun setTravelClass(travelClass: String?){
        val txt : TextView = view.findViewById(R.id.travelClass)
        txt.text = travelClass
    }


    fun setPrice(price: String?){
        val txt : TextView = view.findViewById(R.id.flightPrice)
        txt.text = price
    }

    fun getCardLayout(): View {
        return view.findViewById(R.id.flight_item)
    }

}