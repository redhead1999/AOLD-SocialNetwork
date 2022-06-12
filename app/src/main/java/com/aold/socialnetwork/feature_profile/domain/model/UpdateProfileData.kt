package com.aold.socialnetwork.feature_profile.domain.model

import com.aold.socialnetwork.feature_profile.domain.model.Skill

data class UpdateProfileData(
    val username: String,
    val bio: String,
    val gitHubUrl: String,
    val instagramUrl: String,
    val linkedInUrl: String,
    val skills: List<Skill>,
)
