package com.aold.socialnetwork.feature_chat.presentation.chat

import com.aold.socialnetwork.feature_chat.domain.models.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)