package com.redhead.socialnetwork.feature_post.use_case

import com.redhead.socialnetwork.core.domain.models.Post
import com.redhead.socialnetwork.core.util.Constants
import com.redhead.socialnetwork.core.util.Resource
import com.redhead.socialnetwork.feature_post.domain.repository.PostRepository

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {
    suspend fun invoke(
        page: Int,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): Resource<List<Post>> = repository.getPostsForFollows(page, pageSize)
}