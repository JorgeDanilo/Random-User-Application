package com.example.randomuserapplication.domain.repository

import com.example.randomuserapplication.domain.model.UserResponse


interface UserRepository {

    suspend fun getAll(): UserResponse
}