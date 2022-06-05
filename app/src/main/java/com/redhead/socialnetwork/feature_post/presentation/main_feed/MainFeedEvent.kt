package com.redhead.socialnetwork.feature_post.presentation.main_feed

sealed class MainFeedEvent {
    data class LikedPost(val postInt: String) : MainFeedEvent()
}