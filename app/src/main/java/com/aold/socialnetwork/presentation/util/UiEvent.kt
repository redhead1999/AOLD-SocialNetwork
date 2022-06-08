package com.aold.socialnetwork.presentation.util

import com.aold.socialnetwork.core.util.UiText
import com.aold.socialnetwork.core.util.Event


sealed class UiEvent : Event() {
    data class ShowSnackBar(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
    object OnLogin : UiEvent()
}