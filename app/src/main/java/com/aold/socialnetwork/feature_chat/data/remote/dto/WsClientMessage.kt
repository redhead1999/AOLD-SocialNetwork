package com.aold.socialnetwork.feature_chat.data.remote.dto

data class WsClientMessage(
    val toId: String,
    val text: String,
    val chatId: String?,
)
