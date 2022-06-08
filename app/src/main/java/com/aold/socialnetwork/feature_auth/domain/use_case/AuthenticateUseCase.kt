package com.aold.socialnetwork.feature_auth.domain.use_case

import com.aold.socialnetwork.core.util.SimpleResource
import com.aold.socialnetwork.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): SimpleResource = repository.authenticate()
}