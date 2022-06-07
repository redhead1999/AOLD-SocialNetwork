package com.redhead.socialnetwork.presentation.activity

import com.redhead.socialnetwork.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redhead.socialnetwork.core.presentation.components.StandardToolbar
import com.redhead.socialnetwork.presentation.ui.theme.SpaceMedium
import kotlinx.coroutines.launch

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

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                val scope = rememberCoroutineScope()
                var title by remember {
                    mutableStateOf("")
                }
                var description by remember {
                    mutableStateOf("")
                }
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    placeholder = {
                        Text("Title")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    placeholder = {
                        Text("Description")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        scope.launch {
//                    service.sendNotification(
//                        title = title,
//                        description = description
//                    )
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Send")
                }
            }
        }
    }
}
