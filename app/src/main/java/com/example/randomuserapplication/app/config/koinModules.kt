package com.example.randomuserapplication.app.config

import com.example.randomuserapplication.domain.repository.UserRepository
import com.example.randomuserapplication.resources.remote.api.UserApi
import com.example.randomuserapplication.resources.repository.UserDataRepository
import org.koin.dsl.module

val uiModule = module {

}

val repositoryModule = module {
    single<UserRepository> {UserDataRepository(get())}
}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { createApi<UserApi>(get()) }
}