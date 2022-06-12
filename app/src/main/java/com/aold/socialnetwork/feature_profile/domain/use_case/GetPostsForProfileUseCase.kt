package com.aold.socialnetwork.feature_profile.domain.use_case

import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.domain.repository.ProfileRepository
import com.aold.socialnetwork.core.util.Resource

class GetPostsForProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, page: Int): Resource<List<Post>> {
        return repository.getPostsPaged(
            userId = userId,
            page = page
        )
    }
}