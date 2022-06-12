package com.aold.socialnetwork.feature_profile.search

import androidx.compose.foundation.clickable
import com.aold.socialnetwork.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aold.socialnetwork.core.domain.models.User
import com.aold.socialnetwork.core.domain.states.StandardTextFieldState
import com.aold.socialnetwork.core.presentation.components.StandardTextField
import com.aold.socialnetwork.core.presentation.components.StandardToolbar
import com.aold.socialnetwork.core.util.Screen
import com.aold.socialnetwork.core.presentation.components.UserProfileItem
import com.aold.socialnetwork.presentation.ui.theme.IconSizeMedium
import com.aold.socialnetwork.presentation.ui.theme.SpaceLarge
import com.aold.socialnetwork.presentation.ui.theme.SpaceMedium

@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    navController: NavController,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    viewModel: SearchViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.search_for_users),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
                .clickable { onProfileClick() }
        ) {
            StandardTextField(
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.searchState.value.text,
                hint = stringResource(id = R.string.search),
                error = "",
                leadingIcon = Icons.Default.Search,
                onValueChange = {
                    viewModel.setSearchState(
                        StandardTextFieldState(text = it)
                    )
                }
            )

            Spacer(modifier = Modifier.height(SpaceLarge))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(10) {
                    UserProfileItem(
                        user = User(
                            profilePictureUrl = "",
                            username = "Юрий Кирилин",
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
                        },
                        onProfileClick = {
                            onNavigate(Screen.ProfileScreen.route)
                        }
                    )
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }
    }
}