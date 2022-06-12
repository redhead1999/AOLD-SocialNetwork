package com.aold.socialnetwork.feature_post.presentation.util

import com.aold.socialnetwork.core.util.Error

sealed class PostDescriptionError : Error() {
    object FieldEmpty : PostDescriptionError()
}