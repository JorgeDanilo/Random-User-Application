package com.example.randomuserapplication.resources.remote.api

import com.example.randomuserapplication.resources.remote.response.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface UserApi {

    @GET("?results=6")
    fun getAll(): Deferred<List<UserResponse>>
}