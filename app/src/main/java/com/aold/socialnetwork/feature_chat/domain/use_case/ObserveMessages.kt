package com.aold.socialnetwork.feature_chat.domain.use_case

import com.aold.socialnetwork.feature_chat.domain.models.Message
import com.aold.socialnetwork.feature_chat.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow

class ObserveMessages(
    private val repository: ChatRepository
) {

    operator fun invoke(): Flow<Message> {
        return repository.observeMessages()
    }

}