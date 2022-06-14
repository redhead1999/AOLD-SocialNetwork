package com.aold.socialnetwork.feature_chat.data.remote

import com.aold.socialnetwork.feature_chat.domain.models.Message
import com.aold.socialnetwork.feature_chat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        userName: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "wss://192.168.1.106:3000/"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket : Endpoints("$BASE_URL/chat-socket")
    }
}