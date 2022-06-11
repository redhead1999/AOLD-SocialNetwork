package com.aold.socialnetwork.feature_chat.data.remote

import com.aold.socialnetwork.feature_chat.data.remote.dto.WsClientMessage
import com.aold.socialnetwork.feature_chat.data.remote.dto.WsServerMessage
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import kotlinx.coroutines.channels.ReceiveChannel

interface ChatService {

    @Receive
    fun observeEvents(): ReceiveChannel<WebSocket.Event>

    @Send
    fun sendMessage(message: WsClientMessage)

    @Receive
    fun observeMessages(): ReceiveChannel<WsServerMessage>
}