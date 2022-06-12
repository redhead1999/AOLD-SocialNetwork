package com.aold.socialnetwork.feature_profile.domain.use_case

import com.aold.socialnetwork.core.domain.repository.ProfileRepository

class LogoutUseCase(
    private val repository: ProfileRepository
) {

    operator fun invoke() {
        repository.logout()
    }
}