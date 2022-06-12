package com.aold.socialnetwork.feature_profile.search

sealed class SearchEvent {
    data class Query(val query: String): SearchEvent()
    data class ToggleFollowState(val userId: String): SearchEvent()
}
