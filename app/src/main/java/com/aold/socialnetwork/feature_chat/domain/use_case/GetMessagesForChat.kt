package com.aold.socialnetwork.feature_chat.domain.use_case

import com.aold.socialnetwork.core.util.Constants.DEFAULT_PAGE_SIZE
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_chat.domain.models.Message
import com.aold.socialnetwork.feature_chat.domain.repository.ChatRepository


class GetMessagesForChat(
    private val repository: ChatRepository
) {

    suspend operator fun invoke(
        chatId: String,
        page: Int,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ): Resource<List<Message>> {
        return repository.getMessagesForChat(
            chatId, page, pageSize
        )
    }
}