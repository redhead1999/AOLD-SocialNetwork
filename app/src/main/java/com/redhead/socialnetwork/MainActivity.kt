package com.redhead.socialnetwork

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.redhead.socialnetwork.core.presentation.components.StandardScaffold
import com.redhead.socialnetwork.core.presentation.components.Navigation
import com.redhead.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.redhead.socialnetwork.core.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialNetworkTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.MainFeedScreen.route,
                            Screen.ChatScreen.route,
                            Screen.ActivityScreen.route,
                            Screen.ProfileScreen.route,
                        ),
                        modifier = Modifier.fillMaxSize(),
                        onFabClick = {
                            navController.navigate(Screen.CreatePostScreen.route)
                        }
                    ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}