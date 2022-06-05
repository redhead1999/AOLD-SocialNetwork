package com.redhead.socialnetwork.feature_post.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.redhead.socialnetwork.core.domain.models.Post
import com.redhead.socialnetwork.feature_post.data.remote.PostApi

class PostSource(
    private val api: PostApi,
    private val source: Source
): PagingSource<Int, Post>() {
    private var currentpage = 0
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        TODO("Not yet implemented")
    }

}

sealed class Source {
    object Follows : Source()
    data class Profile(val userId: String) : Source()
}