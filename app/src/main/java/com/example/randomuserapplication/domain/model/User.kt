package com.example.randomuserapplication.domain.model

import com.google.gson.annotations.SerializedName

data class User (
	@SerializedName("gender") val gender : String,
	@SerializedName("name") val name : Name,
	@SerializedName("location") val location : Location,
	@SerializedName("email") val email : String,
	@SerializedName("dob") val dob : Dob,
	@SerializedName("phone") val phone : String,
	@SerializedName("picture") val picture : Picture
)