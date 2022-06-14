package com.aold.socialnetwork.feature_chat.presentation.chat

import com.aold.socialnetwork.feature_chat.domain.models.Chat

data class ChatState(
    val chats: List<Chat> = emptyList(),
    val isLoading: Boolean = false
)