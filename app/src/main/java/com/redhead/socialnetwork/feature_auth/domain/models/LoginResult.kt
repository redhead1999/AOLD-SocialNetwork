package com.redhead.socialnetwork.feature_auth.domain.models

import com.redhead.socialnetwork.core.util.SimpleResource
import com.redhead.socialnetwork.feature_auth.presentation.util.AuthError

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
