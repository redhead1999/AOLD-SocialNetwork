package com.aold.socialnetwork.core.domain.models

import androidx.compose.ui.text.AnnotatedString

data class Comment(
    val commentId: Int = -1,
    val username: String = "",
    val profilePictureUrl: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val comment: String = "",
    val isLiked: Boolean = false,
    val likeCount: Int = 12,
    val formattedTime: AnnotatedString
)
