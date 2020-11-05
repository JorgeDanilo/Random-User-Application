package com.example.randomuserapplication.domain.model

import com.google.gson.annotations.SerializedName

data class UserResponse (
	@SerializedName("results") val results : List<User>,
	@SerializedName("info") val info : Info
)