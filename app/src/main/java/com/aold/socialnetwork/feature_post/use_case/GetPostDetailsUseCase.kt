package com.aold.socialnetwork.feature_post.use_case

import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

class GetPostDetailsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<Post> {
        return repository.getPostDetails(postId)
    }
}