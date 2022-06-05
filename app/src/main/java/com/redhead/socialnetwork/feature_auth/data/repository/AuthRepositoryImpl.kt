package com.redhead.socialnetwork.feature_auth.data.repository

import android.content.SharedPreferences
import com.redhead.socialnetwork.core.util.SimpleResource
import com.redhead.socialnetwork.feature_auth.data.remote.AuthApi
import com.redhead.socialnetwork.feature_auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val sharedPreferences: SharedPreferences
) : AuthRepository {
    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): SimpleResource {
        TODO("Not yet implemented")
    }

    override suspend fun authenticate(): SimpleResource {
        TODO("Not yet implemented")
    }

}