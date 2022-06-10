package com.aold.socialnetwork.feature_activity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.test.core.app.ActivityScenario
import com.aold.socialnetwork.R
import com.aold.socialnetwork.core.domain.models.Activity
import com.aold.socialnetwork.core.util.UiEvent
import com.aold.socialnetwork.core.util.UiText
import com.aold.socialnetwork.feature_activity.domain.ActivityAction
import com.aold.socialnetwork.presentation.ui.theme.ProfilePictureSizeSmall
import com.aold.socialnetwork.presentation.ui.theme.SpaceExtraSmall
import com.aold.socialnetwork.presentation.ui.theme.SpaceMedium
import com.aold.socialnetwork.presentation.ui.theme.SpaceSmall

@Composable
fun ActivityItem(
    activity: Activity,
    modifier: Modifier = Modifier,
    onActivityClick: () -> Unit = {},
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 20.dp,
        modifier = Modifier
            .padding(horizontal = SpaceExtraSmall)
            .clickable { onActivityClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(SpaceMedium)
        ) {
            Image(
                painterResource(id = R.drawable.philipp),
                contentDescription = "Аватарка",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(ProfilePictureSizeSmall)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = SpaceMedium)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val fillerText = when (activity.actionType) {
                        is ActivityAction.LikedPost ->
                            stringResource(id = R.string.liked)
                        is ActivityAction.CommentedOnPost ->
                            stringResource(id = R.string.commented_on)
                        is ActivityAction.FollowedYou ->
                            stringResource(id = R.string.followed_you)
                        else -> ""
                    }
                    val actionText = when (activity.actionType) {
                        is ActivityAction.LikedPost ->
                            stringResource(id = R.string.your_post)
                        is ActivityAction.CommentedOnPost ->
                            stringResource(id = R.string.your_post)
                        is ActivityAction.FollowedYou -> ""
                        else -> ""
                    }
                    Text(
                        text = buildAnnotatedString {
                            val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                            withStyle(boldStyle) { append(activity.username) }
                            append(" $fillerText ")
                            append(actionText)
                        },
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                }
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = activity.formattedTime,
                    textAlign = TextAlign.Right,
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}