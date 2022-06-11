package com.aold.socialnetwork.feature_chat.domain.use_case

import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_chat.domain.models.Chat
import com.aold.socialnetwork.feature_chat.domain.repository.ChatRepository

class GetChatsForUser(
    private val repository: ChatRepository
) {

    suspend operator fun invoke(): Resource<List<Chat>> {
        return repository.getChatsForUser()
    }
}