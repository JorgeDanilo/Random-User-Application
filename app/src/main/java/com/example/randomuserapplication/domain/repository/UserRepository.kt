package com.example.randomuserapplication.domain.repository

import com.example.randomuserapplication.domain.model.User
import kotlinx.coroutines.Deferred

interface UserRepository {

    suspend fun getAll(): List<User>
}