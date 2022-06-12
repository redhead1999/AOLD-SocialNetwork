package com.aold.socialnetwork.core.util

import com.aold.socialnetwork.core.domain.models.Post

interface PostLiker {

    suspend fun toggleLike(
        posts: List<Post>,
        parentId: String,
        onRequest: suspend (isLiked: Boolean) -> SimpleResource,
        onStateUpdated: (List<Post>) -> Unit
    )
}