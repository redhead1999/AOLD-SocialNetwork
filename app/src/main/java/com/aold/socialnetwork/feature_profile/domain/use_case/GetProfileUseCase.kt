package com.aold.socialnetwork.feature_profile.domain.use_case

import com.aold.socialnetwork.core.domain.repository.ProfileRepository
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_profile.domain.model.Profile

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}