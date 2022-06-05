package com.redhead.socialnetwork.feature_post.domain.repository

import android.net.Uri
import com.redhead.socialnetwork.core.domain.models.Post
import com.redhead.socialnetwork.core.util.Resource
import com.redhead.socialnetwork.core.util.SimpleResource

interface PostRepository {

    suspend fun getPostsForFollows(page: Int, pageSize: Int): Resource<List<Post>>

    suspend fun createPost(description: String, imageUri: Uri): SimpleResource
}