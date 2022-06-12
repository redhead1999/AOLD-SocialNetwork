package com.aold.socialnetwork.feature_auth.presentation.util

import com.aold.socialnetwork.core.util.Error

sealed class AuthError : Error() {
    object FieldEmpty : AuthError()
    object InputTooShort : AuthError()
    object InvalidEmail : AuthError()
    object InvalidPassword : AuthError()
}