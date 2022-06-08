package com.aold.socialnetwork.feature_chat.data.remote.dto

import com.aold.socialnetwork.core.util.DateFormatUtil
import com.aold.socialnetwork.feature_chat.domain.models.Message
import kotlinx.serialization.Serializable
import java.text.DateFormat
import java.util.*


@Serializable
data class MessageDto(
    val text: String,
    val timestamp: Long,
    val username: String,
    val id: String
) {
    fun toMessage(): Message {
        val date = Date(timestamp)
        val formattedDate = DateFormat
            .getDateInstance(DateFormat.DEFAULT)
            .format(date)
        return Message(
            text = text,
            formattedTime = formattedDate,
            username = username
        )
    }
}