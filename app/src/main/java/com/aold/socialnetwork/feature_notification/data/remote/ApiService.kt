package com.aold.socialnetwork.feature_notification.data.remote

interface ApiService {

    suspend fun sendNotification(title: String, description: String)

    companion object{
        //fixMe установить правильный хост и порт для теста
        const val SEND_NOTIFICATION = "http://192.168.1.106:3000/sendNotification"
    }

}