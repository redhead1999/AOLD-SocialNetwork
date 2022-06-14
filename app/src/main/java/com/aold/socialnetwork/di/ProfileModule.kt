package com.aold.socialnetwork.di

import android.content.SharedPreferences
import com.aold.socialnetwork.core.data.repository.ProfileRepositoryImpl
import com.aold.socialnetwork.core.domain.repository.ProfileRepository
import com.aold.socialnetwork.core.domain.use_case.ToggleFollowStateForUserUseCase
import com.aold.socialnetwork.feature_post.data.remote.PostApi
import com.aold.socialnetwork.feature_profile.data.ProfileApi
import com.aold.socialnetwork.feature_profile.domain.use_case.*
import com.google.gson.Gson
import com.aold.socialnetwork.feature_profile.domain.use_case.GetProfileUseCase
import com.aold.socialnetwork.feature_profile.domain.use_case.GetSkillsUseCase
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
object ProfileModule {

    @Provides
    @Singleton
    fun provideProfileApi(client: OkHttpClient): ProfileApi {
        return Retrofit.Builder()
            .baseUrl(ProfileApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ProfileApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(
        profileApi: ProfileApi,
        postApi: PostApi,
        gson: Gson,
        sharedPreferences: SharedPreferences
    ): ProfileRepository {
        return ProfileRepositoryImpl(profileApi, postApi, gson, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideProfileUseCases(repository: ProfileRepository): ProfileUseCases {
        return ProfileUseCases(
            getProfile = GetProfileUseCase(repository),
            getSkills = GetSkillsUseCase(repository),
            updateProfile = UpdateProfileUseCase(repository),
            setSkillSelected = SetSkillSelectedUseCase(),
            getPostsForProfile = GetPostsForProfileUseCase(repository),
            searchUser = SearchUserUseCase(repository),
            toggleFollowStateForUser = ToggleFollowStateForUserUseCase(repository),
            logout = LogoutUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideToggleFollowForUserUseCase(repository: ProfileRepository): ToggleFollowStateForUserUseCase {
        return ToggleFollowStateForUserUseCase(repository)
    }

}