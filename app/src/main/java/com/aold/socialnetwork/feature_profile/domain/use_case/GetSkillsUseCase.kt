package com.aold.socialnetwork.feature_profile.domain.use_case

import com.aold.socialnetwork.core.domain.repository.ProfileRepository
import com.aold.socialnetwork.core.util.Resource
import com.aold.socialnetwork.feature_profile.domain.model.Skill

class GetSkillsUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(): Resource<List<Skill>> {
        return repository.getSkills()
    }
}