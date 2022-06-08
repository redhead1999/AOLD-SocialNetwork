package com.aold.socialnetwork.presentation.main_feed

sealed class MainFeedEvent {
    data class LikedPost(val postId: String): MainFeedEvent()
}
