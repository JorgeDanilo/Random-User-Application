package com.example.randomuserapplication.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomuserapplication.domain.model.User
import com.example.randomuserapplication.domain.model.UserResponse
import com.example.randomuserapplication.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainUsersViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(context = Main + viewModelJob)

    private val _users: MutableLiveData<UserResponse> = MutableLiveData()

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    val users: LiveData<UserResponse> get() = _users

    val loading: LiveData<Boolean> get() = _loading

    val error: LiveData<Throwable> get() = _error

    fun getAll() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _users.value = repository.getAll()
                _loading.value = false
            } catch (t: Throwable) {
                _error.value = t
            } finally {
                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
