package com.aold.socialnetwork.feature_notification

import android.app.Application
import com.onesignal.OneSignal


class PushNotification : Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    companion object{
        private const val ONESIGNAL_APP_ID = "338e954b-c0a5-4e2a-a558-d1f7d02109e9"
    }

}