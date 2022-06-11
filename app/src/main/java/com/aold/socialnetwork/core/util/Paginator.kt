package com.aold.socialnetwork.core.util

interface Paginator<T> {

    suspend fun loadNextItems()
}