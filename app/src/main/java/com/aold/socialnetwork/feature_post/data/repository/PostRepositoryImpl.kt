package com.aold.socialnetwork.feature_post.data.repository

import android.net.Uri
import com.google.gson.Gson
import com.aold.socialnetwork.R
import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.core.util.SimpleResource
import com.aold.socialnetwork.core.util.UiText
import com.aold.socialnetwork.feature_post.data.remote.PostApi
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository
import okio.IOException
import retrofit2.HttpException

class PostRepositoryImpl(
    private val api: PostApi,
    private val gson: Gson
) : PostRepository {
    override suspend fun getPostsForFollows(page: Int, pageSize: Int): Resource<List<Post>> {
        return try {
            val posts = api.getPostsForFollows(page = page, pageSize = pageSize)
            Resource.Success(data = posts)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server),
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong),
            )
        }
    }

    override suspend fun createPost(description: String, imageUri: Uri): SimpleResource {
        TODO("Not yet implemented")
    }
}