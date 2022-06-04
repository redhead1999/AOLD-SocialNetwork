package com.redhead.socialnetwork.presentation.activity

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
import com.redhead.socialnetwork.core.presentation.components.StandardToolbar
import com.redhead.socialnetwork.presentation.ui.theme.SpaceMedium

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
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(SpaceMedium)
        ) {
            items(20) {
                //fixMe
                if(it < 19) {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }
    }
}