package com.aold.socialnetwork.feature_chat.data.remote.util

import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_chat.data.remote.ChatApi
import com.aold.socialnetwork.feature_chat.data.remote.ChatService
import com.aold.socialnetwork.feature_chat.di.ScarletInstance
import com.aold.socialnetwork.feature_chat.domain.models.Chat
import com.aold.socialnetwork.feature_chat.domain.models.Message
import com.aold.socialnetwork.feature_chat.domain.repository.ChatRepository
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient

class ChatRepositoryImpl(
    private val chatApi: ChatApi,
    private val okHttpClient: OkHttpClient
): ChatRepository {

    private var chatService: ChatService? = null

    override fun initialize() {
        chatService = ScarletInstance.getNewInstance(okHttpClient)
    }

    override suspend fun getChatsForUser(): Resource<List<Chat>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMessagesForChat(
        chatId: String,
        page: Int,
        pageSize: Int
    ): Resource<List<Message>> {
        TODO("Not yet implemented")
    }

    override fun observeChatEvents(): Flow<WebSocket.Event> {
        TODO("Not yet implemented")
    }

    override fun observeMessages(): Flow<Message> {
        TODO("Not yet implemented")
    }

    override fun sendMessage(toId: String, text: String, chatId: String?) {
        TODO("Not yet implemented")
    }
}