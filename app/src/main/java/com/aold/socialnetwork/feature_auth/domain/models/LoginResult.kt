package com.aold.socialnetwork.feature_auth.domain.models

import com.aold.socialnetwork.core.util.SimpleResource
import com.aold.socialnetwork.feature_auth.presentation.util.AuthError

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
