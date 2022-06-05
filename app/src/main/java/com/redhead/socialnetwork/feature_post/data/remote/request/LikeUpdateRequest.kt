package com.redhead.socialnetwork.feature_post.data.remote.request

data class LikeUpdateRequest(
    val parentId: String,
    val parentType: Int
)
