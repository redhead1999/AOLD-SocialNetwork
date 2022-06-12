package com.aold.socialnetwork.feature_profile.search

import com.aold.socialnetwork.core.domain.models.UserItem

data class SearchState(
    val userItems: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)
