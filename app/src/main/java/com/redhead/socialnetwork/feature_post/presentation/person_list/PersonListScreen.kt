package com.redhead.socialnetwork.feature_post.presentation.person_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.ImageLoader
import com.redhead.socialnetwork.R
import com.redhead.socialnetwork.core.domain.models.User
import com.redhead.socialnetwork.core.presentation.components.StandardToolbar
import com.redhead.socialnetwork.presentation.profile.components.UserProfileItem
import com.redhead.socialnetwork.presentation.ui.theme.IconSizeMedium
import com.redhead.socialnetwork.presentation.ui.theme.SpaceLarge
import com.redhead.socialnetwork.presentation.ui.theme.SpaceMedium

@ExperimentalMaterialApi
@Composable
fun PersonListScreen(
    scaffoldState: ScaffoldState,
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.liked_by),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(SpaceLarge)
        ) {
            items(10) {
                UserProfileItem(
                    user = User(
                        profilePictureUrl = "",
                        username = "Just_Amalll",
                        description = "Some Random Text Here",
                        followerCount = 702,
                        followingCount = 410,
                        postCount = 4
                    ),
                    actionIcon = {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground,
                            modifier = Modifier.size(IconSizeMedium)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }
    }
}