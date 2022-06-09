package com.aold.socialnetwork.feature_chat.presentation.rooms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aold.socialnetwork.R
import com.aold.socialnetwork.core.domain.models.Activity
import com.aold.socialnetwork.core.presentation.components.StandardToolbar
import com.aold.socialnetwork.core.util.DateFormatUtil
import com.aold.socialnetwork.core.util.Screen
import com.aold.socialnetwork.feature_activity.domain.ActivityAction
import com.aold.socialnetwork.presentation.ui.theme.SpaceExtraLarge
import com.aold.socialnetwork.presentation.ui.theme.SpaceMedium
import kotlinx.coroutines.flow.collectLatest
import kotlin.random.Random

@Composable
fun RoomsScreen(
    navController: NavController,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: RoomsViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            title = {
                Text(
                    text = stringResource(id = R.string.your_chat),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            navActions = {
                IconButton(onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )
                }

            }
        )


        LaunchedEffect(key1 = true) {
            viewModel.onJoinChat.collectLatest { room ->
                onNavigate("chat_screen/$room")
            }
        }


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(SpaceMedium)
        ) {
            items(10) {
                RoomItem(
                    activity = Activity(
                        username = "Юрий Кирилин",
                        actionType = if (Random.nextInt(2) == 0)
                            ActivityAction.MessagedYou
                        else ActivityAction.LikedPost,
                        formattedTime = DateFormatUtil.timestampToFormattedString(
                            timestamp = System.currentTimeMillis(),
                            pattern = "dd MMM, HH:mm"
                        )
                    ),
                    onRoomClick = {
                        onNavigate(Screen.ChatScreen.route)
                    }
                )
                if (it < 19) Spacer(modifier = Modifier.height(SpaceMedium))
            }
            item {
                Spacer(modifier = Modifier.height(SpaceExtraLarge))
            }
        }
    }
}