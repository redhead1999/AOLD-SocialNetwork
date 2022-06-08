package com.aold.socialnetwork.presentation.main_feed

data class MainFeedState(
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
)
