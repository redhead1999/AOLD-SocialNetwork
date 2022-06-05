package com.redhead.socialnetwork.feature_post.use_case

data class PostUseCases(
    val getPostsForFollows: GetPostsForFollowsUseCase,
    val createPostUseCase: CreatePostUseCase
)