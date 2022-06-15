package com.aold.socialnetwork.feature_chat.presentation.message

import com.aold.socialnetwork.feature_chat.domain.models.Message

data class MessageState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false,
    val canSendMessage: Boolean = false
)
