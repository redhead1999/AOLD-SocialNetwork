package com.redhead.socialnetwork.feature_activity.presentation

import com.redhead.socialnetwork.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.redhead.socialnetwork.presentation.activity.ActivityViewModel
import com.redhead.socialnetwork.core.domain.models.Activity
import com.redhead.socialnetwork.core.presentation.components.StandardToolbar
import com.redhead.socialnetwork.core.util.DateFormatUtil
import com.redhead.socialnetwork.feature_activity.domain.ActivityAction
import com.redhead.socialnetwork.presentation.activity.components.ActivityItem
import com.redhead.socialnetwork.presentation.ui.theme.SpaceExtraLarge
import com.redhead.socialnetwork.presentation.ui.theme.SpaceMedium
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
                            pattern = "MMM dd, HH:mm"
                        )
                    )
                )
                if (it < 19) Spacer(modifier = Modifier.height(SpaceMedium))
            }
            item {
                Spacer(modifier =Modifier.height(SpaceExtraLarge))
            }
        }
    }
}