package com.example.climap1.data.model

import android.os.Parcel
import android.os.Parcelable

class WeatherResponse (
    val coord: Coordenadas?,
    val weather: List<Weather>?,
    val base : String?,
    val main : MainWeather?,
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Coordenadas::class.java.classLoader),
        parcel.createTypedArrayList(Weather.CREATOR),
        parcel.readString(),
        parcel.readParcelable(MainWeather::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(coord, flags)
        parcel.writeTypedList(weather)
        parcel.writeString(base)
        parcel.writeParcelable(main, flags)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherResponse> {
        override fun createFromParcel(parcel: Parcel): WeatherResponse {
            return WeatherResponse(parcel)
        }

        override fun newArray(size: Int): Array<WeatherResponse?> {
            return arrayOfNulls(size)
        }
    }


}