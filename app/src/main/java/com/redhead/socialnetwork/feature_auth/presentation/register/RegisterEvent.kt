package com.redhead.socialnetwork.feature_auth.presentation.register

sealed class RegisterEvent {
    data class EnteredUserName(val value: String) : RegisterEvent()
    data class EnteredEmail(val value: String) : RegisterEvent()
    data class EnteredPassword(val value: String) : RegisterEvent()
    object TogglePasswordVisibility : RegisterEvent()
    object Register : RegisterEvent()
}