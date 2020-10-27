package com.example.randomuserapplication.resources.remote.api

import com.example.randomuserapplication.domain.model.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserApi {

    @GET("??exc=registered,login,id,nat,cell&results=6")
    @Headers("content-type: application/json")
    fun getAll(): Deferred<UserResponse>
}