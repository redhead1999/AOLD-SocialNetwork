package com.aold.socialnetwork.feature_post.use_case

import com.aold.socialnetwork.core.domain.models.Comment
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

class GetCommentsForPostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<List<Comment>> {
        return repository.getCommentsForPost(postId)
    }
}