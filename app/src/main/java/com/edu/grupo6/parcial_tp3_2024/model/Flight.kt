package com.edu.grupo6.parcial_tp3_2024.model

import android.os.Parcel
import android.os.Parcelable

class Flight (
    airline: String?,
    duration: String?,
    departureId: String?,
    departureName: String?,
    arrivalId: String?,
    arrivalName: String?,
    travelClass: String?,
    price: String?) : Parcelable {

    val airline : String?
    val duration: String?
    val departureId: String?
    val departureName: String?
    val arrivalId: String?
    val arrivalName: String?
    val travelClass: String?
    val price: String?

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    init {
        this.airline = airline
        this.duration = duration
        this.departureId = departureId
        this.departureName = departureName
        this.arrivalId = arrivalId
        this.arrivalName = arrivalName
        this.travelClass = travelClass
        this.price = price


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(airline)
        parcel.writeString(duration)
        parcel.writeString(departureId)
        parcel.writeString(departureName)
        parcel.writeString(arrivalId)
        parcel.writeString(arrivalName)
        parcel.writeString(travelClass)
        parcel.writeString(price)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Flight> {
        override fun createFromParcel(parcel: Parcel): Flight {
            return Flight(parcel)
        }

        override fun newArray(size: Int): Array<Flight?> {
            return arrayOfNulls(size)
        }
    }


}