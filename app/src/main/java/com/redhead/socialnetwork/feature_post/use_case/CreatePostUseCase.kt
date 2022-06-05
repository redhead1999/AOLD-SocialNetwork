package com.redhead.socialnetwork.feature_post.use_case

import android.net.Uri
import com.redhead.socialnetwork.R
import com.redhead.socialnetwork.core.util.Resource
import com.redhead.socialnetwork.core.util.SimpleResource
import com.redhead.socialnetwork.core.util.UiText
import com.redhead.socialnetwork.feature_post.domain.repository.PostRepository

class CreatePostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(
        description: String,
        imageUri: Uri?
    ): SimpleResource {
        if (imageUri == null) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_no_image_picked)
            )
        }
        if (description.isBlank()) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_description_blank)
            )
        }
        return repository.createPost(description, imageUri)

    }
}