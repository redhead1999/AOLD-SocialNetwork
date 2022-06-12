package com.aold.socialnetwork.feature_post.presentation.person_list

import com.aold.socialnetwork.core.util.Event


sealed class PostEvent : Event() {
    object OnLiked: PostEvent()
}