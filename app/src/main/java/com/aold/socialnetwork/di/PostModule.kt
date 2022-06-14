package com.aold.socialnetwork.di

import com.aold.socialnetwork.core.domain.use_case.DeletePost
import com.google.gson.Gson
import com.aold.socialnetwork.feature_post.data.remote.PostApi
import com.aold.socialnetwork.feature_post.data.repository.PostRepositoryImpl
import com.aold.socialnetwork.feature_post.domain.repository.PostRepository
import com.aold.socialnetwork.feature_post.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {

    @Provides
    @Singleton
    fun providePostApi(client: OkHttpClient): PostApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(PostApi.BASE_URL)
        .client(client)
        .build()
        .create(PostApi::class.java)

    @Provides
    @Singleton
    fun providePostRepository(api: PostApi, gson: Gson): PostRepository =
        PostRepositoryImpl(api, gson)

    @Provides
    @Singleton
    fun providePostUseCases(repository: PostRepository): PostUseCases {
        return PostUseCases(
            getPostsForFollows = GetPostsForFollowsUseCase(repository),
            createPostUseCase = CreatePostUseCase(repository),
            getPostDetails = GetPostDetailsUseCase(repository),
            getCommentsForPost = GetCommentsForPostUseCase(repository),
            createComment = CreateCommentUseCase(repository),
            toggleLikeForParent = ToggleLikeForParentUseCase(repository),
            getLikesForParent = GetLikesForParentUseCase(repository),
            deletePost = DeletePost(repository)
        )
    }
}