package com.example.randomuserapplication.app.config

import com.example.randomuserapplication.app.ui.MainUsersViewModel
import com.example.randomuserapplication.domain.repository.UserRepository
import com.example.randomuserapplication.resources.remote.api.UserApi
import com.example.randomuserapplication.resources.repository.UserDataRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
//    viewModel {MainUsersViewModel(get())}
    single { MainUsersViewModel(get()) }
}

val repositoryModule = module {
    single<UserRepository> {UserDataRepository(get())}
}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideGson() }
    single { provideRetrofit(get(), get())}
    single { createApi<UserApi>(get()) }
}