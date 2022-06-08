package com.aold.socialnetwork.feature_post.domain.repository

import android.net.Uri
import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.core.util.SimpleResource

interface PostRepository {

    suspend fun getPostsForFollows(page: Int, pageSize: Int): Resource<List<Post>>

    suspend fun createPost(description: String, imageUri: Uri): SimpleResource
}