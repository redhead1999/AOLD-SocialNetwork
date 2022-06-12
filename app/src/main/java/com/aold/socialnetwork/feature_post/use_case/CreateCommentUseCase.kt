package com.aold.socialnetwork.feature_post.use_case

import com.aold.socialnetwork.R
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.core.util.SimpleResource
import com.aold.socialnetwork.core.util.UiText
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

class CreateCommentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String, comment: String): SimpleResource {
        if(comment.isBlank()) {
            return Resource.Error(UiText.StringResource(R.string.error_field_empty))
        }
        if(postId.isBlank()) {
            return Resource.Error(UiText.unknownError())
        }
        return repository.createComment(postId, comment)
    }
}