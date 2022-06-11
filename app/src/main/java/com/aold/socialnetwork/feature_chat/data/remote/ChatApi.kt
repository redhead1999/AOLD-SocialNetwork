package com.aold.socialnetwork.feature_chat.data.remote

import com.aold.socialnetwork.feature_chat.data.remote.dto.ChatDto
import com.aold.socialnetwork.feature_chat.data.remote.dto.MessageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ChatApi {

    @GET("/api/chats")
    suspend fun getChatsForUser(): List<ChatDto>

    @GET("/api/chat/messages")
    suspend fun getMessagesForChat(
        @Query("chatId") chatId: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<MessageDto>

    companion object {
        const val BASE_URL = "http://192.168.0.3:8001/"
    }
}