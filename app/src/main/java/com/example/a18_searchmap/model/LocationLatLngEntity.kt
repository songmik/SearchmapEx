package com.example.a18_searchmap.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationLatLngEntity (
    val latitude: Float,
    val longitude: Float
    ):Parcelable