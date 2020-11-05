package com.example.randomuserapplication.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse (
	@SerializedName("results") val results : List<User>,
	@SerializedName("info") val info : Info
): Serializable