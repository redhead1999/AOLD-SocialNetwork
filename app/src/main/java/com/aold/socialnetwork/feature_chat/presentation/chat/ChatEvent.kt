package com.aold.socialnetwork.feature_chat.presentation.chat

sealed class ChatEvent {
    data class EnteredChat(val value: String): ChatEvent()
}