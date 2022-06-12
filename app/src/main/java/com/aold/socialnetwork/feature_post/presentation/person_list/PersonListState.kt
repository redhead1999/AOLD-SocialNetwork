package com.aold.socialnetwork.feature_post.presentation.person_list

import com.aold.socialnetwork.core.domain.models.UserItem

data class PersonListState(
    val users: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)
