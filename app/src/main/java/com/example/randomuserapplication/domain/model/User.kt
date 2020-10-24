package com.example.randomuserapplication.domain.model

data class User(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val dbo: Dob,
    val phone: String,
    val picture: Picture
)

data class Name(val title: String,
                val first: String,
                val last: String)