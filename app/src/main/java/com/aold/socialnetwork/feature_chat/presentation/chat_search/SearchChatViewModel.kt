package com.aold.socialnetwork.feature_chat.presentation.chat_search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.aold.socialnetwork.core.domain.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class SearchChatViewModel @Inject constructor() : ViewModel() {
    private val _searchState = mutableStateOf(StandardTextFieldState())
    val searchState: State<StandardTextFieldState> = _searchState

    private val _onJoinChat = MutableSharedFlow<String>()
    val onJoinChat = _onJoinChat.asSharedFlow()

    fun setSearchState(state: StandardTextFieldState) {
        _searchState.value = state
    }
}