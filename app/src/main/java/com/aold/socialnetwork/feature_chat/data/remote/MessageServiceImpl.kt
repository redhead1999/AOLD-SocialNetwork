package com.aold.socialnetwork.feature_chat.data.remote

import com.aold.socialnetwork.feature_chat.data.remote.dto.MessageDto
import com.aold.socialnetwork.feature_chat.domain.models.Message
import io.ktor.client.*
import io.ktor.client.request.*
import java.lang.Exception

class MessageServiceImpl(
    private val client: HttpClient,

    ) : MessageService {
    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url)
                .map { it.toMessage() }
        } catch (e: Exception) {
            emptyList()
        }
    }

}
