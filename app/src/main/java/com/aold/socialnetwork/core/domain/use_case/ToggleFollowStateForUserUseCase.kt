package com.aold.socialnetwork.core.domain.use_case

import com.aold.socialnetwork.core.domain.repository.ProfileRepository
import com.aold.socialnetwork.core.util.SimpleResource

class ToggleFollowStateForUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, isFollowing: Boolean): SimpleResource {
        return if(isFollowing) {
            repository.unfollowUser(userId)
        } else {
            repository.followUser(userId)
        }
    }
}