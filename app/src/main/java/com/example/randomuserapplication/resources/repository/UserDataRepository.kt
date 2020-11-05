package com.example.randomuserapplication.resources.repository

import com.example.randomuserapplication.domain.repository.UserRepository
import com.example.randomuserapplication.resources.remote.api.UserApi
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class UserDataRepository(private val api: UserApi): UserRepository {

    override suspend fun getAll() = withContext(IO) {
        api.getAll().await()
    }
}