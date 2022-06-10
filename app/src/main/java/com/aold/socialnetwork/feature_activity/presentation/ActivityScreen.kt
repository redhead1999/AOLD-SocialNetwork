package com.aold.socialnetwork.feature_activity.presentation

import com.aold.socialnetwork.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.aold.socialnetwork.core.domain.models.Activity
import com.aold.socialnetwork.core.presentation.components.StandardToolbar
import com.aold.socialnetwork.core.util.DateFormatUtil
import com.aold.socialnetwork.core.util.Screen
import com.aold.socialnetwork.feature_activity.components.ActivityItem
import com.aold.socialnetwork.feature_activity.domain.ActivityAction
import com.aold.socialnetwork.presentation.ui.theme.SpaceExtraLarge
import com.aold.socialnetwork.presentation.ui.theme.SpaceMedium
import kotlin.random.Random

@Composable
fun ActivityScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: ActivityViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = stringResource(id = R.string.your_activity),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(SpaceMedium)
        ) {
            items(10) {
                ActivityItem(
                    activity = Activity(
                        username = "Юрий Кирилин",
                        actionType = if (Random.nextInt(2) == 0)
                            ActivityAction.LikedPost
                        else ActivityAction.CommentedOnPost,
                        formattedTime = DateFormatUtil.timestampToFormattedString(
                            timestamp = System.currentTimeMillis(),
                            pattern = "dd MMM, HH:mm"
                        )
                    ),
                    onActivityClick = {
                        onNavigate(Screen.MainFeedScreen.route)
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