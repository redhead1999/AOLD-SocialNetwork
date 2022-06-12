package com.aold.socialnetwork.feature_activity.domain.use_case

import androidx.paging.PagingData
import com.aold.socialnetwork.core.domain.models.Activity
import com.aold.socialnetwork.feature_activity.domain.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow

class GetActivitiesUseCase(
    private val repository: ActivityRepository
) {

    operator fun invoke(): Flow<PagingData<Activity>> {
        return repository.activities
    }
}