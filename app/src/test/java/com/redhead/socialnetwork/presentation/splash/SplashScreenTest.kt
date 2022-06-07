package com.redhead.socialnetwork.presentation.splash

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.redhead.socialnetwork.MainActivity
import com.redhead.socialnetwork.core.util.Constants
import com.redhead.socialnetwork.core.util.Screen
import com.redhead.socialnetwork.feature_auth.presentation.splash.SplashScreen
import com.redhead.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.compose.ui.test.onNodeWithContentDescription

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @OptIn(ExperimentalComposeUiApi::class,
        androidx.compose.material.ExperimentalMaterialApi::class
    )
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears() = testDispatcher.runBlockingTest {
        composeTestRule.setContent {
            SocialNetworkTheme {
                SplashScreen(
                    dispatcher = testDispatcher
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("logo")
            .assertExists()

        advanceTimeBy(Constants.SPLASH_SCREEN_DURATION)

        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }
    }
}
