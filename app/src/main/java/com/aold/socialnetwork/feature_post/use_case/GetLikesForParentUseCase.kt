package com.aold.socialnetwork.feature_post.use_case

import com.aold.socialnetwork.core.domain.models.UserItem
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

class GetLikesForParentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(parentId: String): Resource<List<UserItem>> {
        return repository.getLikesForParent(parentId)
    }
}