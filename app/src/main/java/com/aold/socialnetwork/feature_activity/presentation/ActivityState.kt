package com.aold.socialnetwork.feature_activity.presentation

import com.aold.socialnetwork.core.domain.models.Activity

data class ActivityState(
    val activities: List<Activity> = emptyList(),
    val isLoading: Boolean = false
)