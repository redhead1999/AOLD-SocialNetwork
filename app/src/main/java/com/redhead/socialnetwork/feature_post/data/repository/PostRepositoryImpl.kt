package com.redhead.socialnetwork.feature_post.data.repository

import android.net.Uri
import com.google.gson.Gson
import com.redhead.socialnetwork.R
import com.redhead.socialnetwork.core.domain.models.Post
import com.redhead.socialnetwork.core.util.Resource
import com.redhead.socialnetwork.core.util.SimpleResource
import com.redhead.socialnetwork.core.util.UiText
import com.redhead.socialnetwork.feature_post.data.remote.request.PostApi
import com.redhead.socialnetwork.feature_post.domain.repository.PostRepository
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