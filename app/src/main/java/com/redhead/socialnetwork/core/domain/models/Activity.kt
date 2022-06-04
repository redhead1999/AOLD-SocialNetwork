package com.redhead.socialnetwork.core.domain.models

import com.redhead.socialnetwork.feature_activity.domain.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)