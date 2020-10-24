package com.example.randomuserapplication.resources.remote.response

import com.example.randomuserapplication.domain.model.*

data class UserResponse(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val dbo: Dob,
    val phone: String,
    val picture: Picture)

fun UserResponse.toModel() = User(
    this.gender,
    this.name,
    this.location,
    this.email,
    this.dbo,
    this.phone,
    this.picture
)
