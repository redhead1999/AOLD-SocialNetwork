package com.aold.socialnetwork.core.presentation.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.aold.socialnetwork.core.domain.models.Post
import com.aold.socialnetwork.core.util.Screen
import com.aold.socialnetwork.feature_activity.presentation.ActivityScreen
import com.aold.socialnetwork.feature_auth.presentation.login.LoginScreen
import com.aold.socialnetwork.feature_auth.presentation.register.RegisterScreen
import com.aold.socialnetwork.feature_auth.presentation.splash.SplashScreen
import com.aold.socialnetwork.feature_chat.presentation.chat.ChatScreen
import com.aold.socialnetwork.feature_chat.presentation.chat_search.SearchСhatScreen
import com.aold.socialnetwork.feature_chat.presentation.message.MessageScreen
import com.aold.socialnetwork.feature_post.presentation.create_post.CreatePostScreen
import com.aold.socialnetwork.feature_profile.presentation.edit_profile.EditProfileScreen
import com.aold.socialnetwork.feature_profile.presentation.profile.ProfileScreen
import com.aold.socialnetwork.feature_profile.search.SearchScreen
import com.aold.socialnetwork.feature_post.presentation.main_feed.MainFeedScreen
import com.aold.socialnetwork.feature_post.presentation.person_list.PersonListScreen
import com.aold.socialnetwork.feature_post.presentation.post_detail.PostDetailScreen
import kotlinx.coroutines.DelicateCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    imageLoader: ImageLoader
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainFeedScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(
                onPopBackStack = navController::popBackStack,
                onNavigate = navController::navigate,
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                onNavigate = navController::navigate,
                onLogin = {
                    navController.popBackStack(route = Screen.LoginScreen.route, inclusive = true)
                    navController.navigate(route = Screen.MainFeedScreen.route)
                },
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(
                navController = navController,
                scaffoldState = scaffoldState,
                onPopBackStack = navController::popBackStack
            )
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }
        composable(Screen.SearchChatScreen.route) {
            SearchСhatScreen(
                navController = navController,
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                imageLoader = imageLoader
            )
        }
        composable(
            route = Screen.MessagesScreen.route + "/{remoteUserId}/{remoteUsername}/{remoteUserProfilePictureUrl}?chatId={chatId}",
            arguments = listOf(
                navArgument("chatId") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument("remoteUserId") {
                    type = NavType.StringType
                },
                navArgument("remoteUsername") {
                    type = NavType.StringType
                },
                navArgument("remoteUserProfilePictureUrl") {
                    type = NavType.StringType
                }
            )
        ) {
            val remoteUserId = it.arguments?.getString("remoteUserId")!!
            val remoteUsername = it.arguments?.getString("remoteUsername")!!
            val remoteUserProfilePictureUrl = it.arguments?.getString("remoteUserProfilePictureUrl")!!
            MessageScreen(
                remoteUserId = remoteUserId,
                remoteUsername = remoteUsername,
                encodedRemoteUserProfilePictureUrl = remoteUserProfilePictureUrl,
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                imageLoader = imageLoader
            )
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(
                navController = navController,
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(
                navController = navController,
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(Screen.PersonListScreen.route) {
            PersonListScreen(
                navController = navController,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                post = Post(
                    username = "Just_Amalll",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "Some Random Text Here",
                    likeCount = 17,
                    commentCount = 7
                )
            )
        }
    }
}