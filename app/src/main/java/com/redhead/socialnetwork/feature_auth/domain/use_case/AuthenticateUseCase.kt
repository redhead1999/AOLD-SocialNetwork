package com.redhead.socialnetwork.feature_auth.domain.use_case

import com.redhead.socialnetwork.core.util.SimpleResource
import com.redhead.socialnetwork.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): SimpleResource = repository.authenticate()
}