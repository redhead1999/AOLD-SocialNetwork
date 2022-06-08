package com.aold.socialnetwork.core.domain.models

import com.aold.socialnetwork.feature_activity.domain.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)