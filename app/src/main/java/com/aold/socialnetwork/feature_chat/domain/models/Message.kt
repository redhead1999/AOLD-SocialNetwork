package com.aold.socialnetwork.feature_chat.domain.models

data class Message(
    val text: String,
    val formattedTime: String,
    val username: String
)