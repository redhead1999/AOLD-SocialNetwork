package com.aold.socialnetwork.feature_profile.domain.use_case

import com.aold.socialnetwork.core.domain.models.UserItem
import com.aold.socialnetwork.core.domain.repository.ProfileRepository
import com.aold.socialnetwork.core.util.Resource

class SearchUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(query: String): Resource<List<UserItem>> {
        if(query.isBlank()) {
            return Resource.Success(data = emptyList())
        }
        return repository.searchUser(query)
    }
}