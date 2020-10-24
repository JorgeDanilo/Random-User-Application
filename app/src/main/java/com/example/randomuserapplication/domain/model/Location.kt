package com.example.randomuserapplication.domain.model

import com.google.gson.annotations.SerializedName

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postCode: Long,
    val coordinates: Coordinate,
    @SerializedName("timezone")
    val timeZone: TimeZone,
)

data class Street(
    val number: Long,
    val name: String
)
