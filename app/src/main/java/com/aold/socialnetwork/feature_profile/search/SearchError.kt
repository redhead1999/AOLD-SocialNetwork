package com.aold.socialnetwork.feature_profile.search

import com.aold.socialnetwork.core.util.UiText
import com.aold.socialnetwork.core.util.Error

data class SearchError(
    val message: UiText
): Error()
