package com.example.randomuserapplication.domain.model

import com.google.gson.annotations.SerializedName

data class Dob (

	@SerializedName("date") val date : String,
	@SerializedName("age") val age : String
)