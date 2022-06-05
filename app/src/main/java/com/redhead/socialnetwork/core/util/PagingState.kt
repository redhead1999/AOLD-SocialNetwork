package com.redhead.socialnetwork.core.util

data class PagingState<T>(
    val items: List<T> = emptyList(),
    val isLoading: Boolean = false,
    val endReached: Boolean = false
)
