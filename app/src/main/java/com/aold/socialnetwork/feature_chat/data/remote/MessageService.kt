package com.aold.socialnetwork.feature_chat.data.remote

import com.aold.socialnetwork.feature_chat.domain.models.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.1.106:3000/"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages : Endpoints("$BASE_URL/messages")
    }
}