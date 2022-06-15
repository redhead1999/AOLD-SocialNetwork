package com.aold.socialnetwork.feature_post.use_case

import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.util.Constants
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(
        page: Int,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): Resource<List<Post>> = repository.getPostsForFollows(page, pageSize)
}