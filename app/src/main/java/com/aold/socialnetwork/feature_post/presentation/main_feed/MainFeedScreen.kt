package com.aold.socialnetwork.feature_post.presentation.main_feed

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import com.aold.socialnetwork.R
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.presentation.components.Post
import com.aold.socialnetwork.core.presentation.components.StandardToolbar
import com.aold.socialnetwork.core.util.Screen
import com.aold.socialnetwork.core.util.sendSharePostIntent
import com.aold.socialnetwork.feature_post.presentation.person_list.PostEvent
import com.aold.socialnetwork.presentation.ui.theme.SpaceLarge
import kotlinx.coroutines.flow.collectLatest

@ExperimentalCoilApi
@Composable
fun MainFeedScreen(
    imageLoader: ImageLoader,
    scaffoldState: ScaffoldState,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: MainFeedViewModel = hiltViewModel()
) {
    val pagingState = viewModel.pagingState.value
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is PostEvent.OnLiked -> {

                }
            }
        }

    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
            navActions = {
                IconButton(onClick = {
                    onNavigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        )
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(pagingState.items.size) { i ->
                    val post = pagingState.items[i]
                    if (i >= pagingState.items.size - 1 && !pagingState.endReached && !pagingState.isLoading) {
                        viewModel.loadNextPosts()
                    }
                    Post(
                        post = post,
                        imageLoader = imageLoader,
                        onUsernameClick = {
                            onNavigate(Screen.ProfileScreen.route + "?userId=${post.userId}")
                        },
                        onPostClick = {
                            onNavigate(Screen.PostDetailScreen.route + "/${post.id}")
                        },
                        onCommentClick = {
                            onNavigate(Screen.PostDetailScreen.route + "/${post.id}?shouldShowKeyboard=true")
                        },
                        onLikeClick = {
                            viewModel.onEvent(MainFeedEvent.LikedPost(post.id))
                        },
                        onShareClick = {
                            context.sendSharePostIntent(post.id)
                        },
                        onDeleteClick = {
                            viewModel.onEvent(MainFeedEvent.DeletePost(post))
                        }
                    )
                    if (i < pagingState.items.size - 1) {
                        Spacer(modifier = Modifier.height(SpaceLarge))
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(90.dp))
                }
            }
            if (pagingState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}