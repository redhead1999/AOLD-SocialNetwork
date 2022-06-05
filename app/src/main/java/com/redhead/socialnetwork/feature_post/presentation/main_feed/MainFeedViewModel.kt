package com.redhead.socialnetwork.feature_post.presentation.main_feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.paging.PagingState
import com.redhead.socialnetwork.core.domain.models.Post
import com.redhead.socialnetwork.core.util.Event
import com.redhead.socialnetwork.feature_post.use_case.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(
    private val postUseCases: PostUseCases
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    //fixMe private val _pagingState = mutableStateOf<PagingState<Post>>(PagingState())
    //fixMe val pagingState: State<PagingState<Post>> = _pagingState
}