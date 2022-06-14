package com.aold.socialnetwork.feature_post.presentation.main_feed

import com.aold.socialnetwork.core.domain.models.Post

sealed class MainFeedEvent {
    data class LikedPost(val postId: String): MainFeedEvent()
    data class DeletePost(val post: Post): MainFeedEvent()
}