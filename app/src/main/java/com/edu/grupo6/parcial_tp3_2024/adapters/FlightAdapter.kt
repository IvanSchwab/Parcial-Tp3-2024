package com.edu.grupo6.parcial_tp3_2024.adapters

import androidx.recyclerview.widget.RecyclerView
import com.edu.grupo6.parcial_tp3_2024.holders.FlightHolder
import com.edu.grupo6.parcial_tp3_2024.model.Flight
import android.view.LayoutInflater
import com.edu.grupo6.parcial_tp3_2024.R
import android.view.ViewGroup

class FlightAdapter(
    private val flights: MutableList<Flight>
) : RecyclerView.Adapter<FlightHolder>() {

    override fun getItemCount() = flights.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.flight, parent, false)
        return (FlightHolder(view))
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {

        val flight = flights[position]

        holder.setAirlineName(flight.airline)
        holder.setDuration(flight.duration)
        holder.setDepartureId(flight.departureId.toString())
        holder.setDepartureName(flight.departureName.toString())
        holder.setArrivalId(flight.arrivalId.toString())
        holder.setArrivalName(flight.arrivalName.toString())
        holder.setTravelClass(flight.travelClass.toString())
        holder.setPrice(flight.price.toString())
    }
}