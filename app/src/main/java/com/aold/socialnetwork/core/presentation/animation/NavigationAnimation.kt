package com.aold.socialnetwork.core.presentation.animation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import coil.ImageLoader
import com.aold.socialnetwork.feature_activity.presentation.ActivityScreen
import com.aold.socialnetwork.feature_post.presentation.main_feed.MainFeedScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun NavAnimation(
    scaffoldState: ScaffoldState,
    imageLoader: ImageLoader
) {

    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable(
            "main_feed_screen",
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "main_feed_screen" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    "activity_screen" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "activity_screen" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    "activity_screen" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            }
        ) {
            MainFeedScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }

        composable(
            "activity_screen",
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "main_feed_screen" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    "main_feed_screen" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "main_feed_screen" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    "main_feed_screen" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(800)
                        )
                    else -> null
                }
            }
        ) {
            ActivityScreen()
        }
    }
}
