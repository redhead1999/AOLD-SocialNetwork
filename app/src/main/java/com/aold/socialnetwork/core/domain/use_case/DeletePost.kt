package com.aold.socialnetwork.core.domain.use_case

import com.aold.socialnetwork.core.util.SimpleResource
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

class DeletePost(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): SimpleResource {
        return repository.deletePost(postId)
    }
}