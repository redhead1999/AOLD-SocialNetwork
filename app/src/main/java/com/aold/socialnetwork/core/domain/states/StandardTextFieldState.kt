package com.aold.socialnetwork.core.domain.states

import com.aold.socialnetwork.core.util.Error

data class StandardTextFieldState(
    val text: String = "",
    val error: Error? = null
)