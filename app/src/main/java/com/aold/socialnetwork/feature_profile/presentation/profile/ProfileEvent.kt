package com.aold.socialnetwork.feature_profile.presentation.profile

import com.aold.socialnetwork.core.domain.models.Post

sealed class ProfileEvent {
    data class LikePost(val postId: String): ProfileEvent()
    data class DeletePost(val post: Post): ProfileEvent()
    object DismissLogoutDialog: ProfileEvent()
    object ShowLogoutDialog: ProfileEvent()
    object Logout: ProfileEvent()
}
