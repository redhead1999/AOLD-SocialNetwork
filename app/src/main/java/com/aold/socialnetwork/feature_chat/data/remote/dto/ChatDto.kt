package com.aold.socialnetwork.feature_chat.data.remote.dto

import com.aold.socialnetwork.feature_chat.domain.models.Chat

data class ChatDto(
    val chatId: String,
    val remoteUserId: String?,
    val remoteUsername: String?,
    val remoteUserProfilePictureUrl: String?,
    val lastMessage: String?,
    val timestamp: Long?
) {
    fun toChat(): Chat? {
        return Chat(
            chatId = chatId,
            remoteUserId = remoteUserId ?: return null,
            remoteUsername = remoteUsername ?: return null,
            remoteUserProfilePictureUrl = remoteUserProfilePictureUrl ?: return null,
            lastMessage = lastMessage ?: return null,
            timestamp = timestamp ?: return null
        )
    }
}