package com.aold.socialnetwork.feature_post.use_case

import android.net.Uri
import com.aold.socialnetwork.R
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.core.util.SimpleResource
import com.aold.socialnetwork.core.util.UiText
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository

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