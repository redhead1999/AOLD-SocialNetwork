package com.redhead.socialnetwork.di

import android.content.SharedPreferences
import com.redhead.socialnetwork.feature_auth.data.remote.AuthApi
import com.redhead.socialnetwork.feature_auth.data.repository.AuthRepositoryImpl
import com.redhead.socialnetwork.feature_auth.domain.repository.AuthRepository
import com.redhead.socialnetwork.feature_auth.domain.use_case.AuthenticateUseCase
import com.redhead.socialnetwork.feature_auth.domain.use_case.LoginUseCase
import com.redhead.socialnetwork.feature_auth.domain.use_case.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient): AuthApi = Retrofit.Builder()
        .baseUrl(AuthApi.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi, sharedPreferences: SharedPreferences): AuthRepositoryImpl =
        AuthRepositoryImpl(api, sharedPreferences)

    @Provides
    @Singleton
    fun provideRegisterUseCase(repository: AuthRepository): RegisterUseCase =
        RegisterUseCase(repository)

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase =
        LoginUseCase(repository)

    @Provides
    @Singleton
    fun provideAuthenticationUseCase(repository: AuthRepository): AuthenticateUseCase =
        AuthenticateUseCase(repository)

}