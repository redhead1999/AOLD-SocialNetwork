package com.aold.socialnetwork.feature_chat.domain.models

data class Message(
    val fromId: String,
    val toId: String,
    val text: String,
    val formattedTime: String,
    val chatId: String?,
)