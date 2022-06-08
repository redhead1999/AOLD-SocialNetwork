package com.aold.socialnetwork.presentation.activity

import com.aold.socialnetwork.R

import androidx.compose.foundation.layout.*
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
import com.aold.socialnetwork.core.presentation.components.StandardToolbar
import com.aold.socialnetwork.feature_notification.data.remote.ApiServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import kotlinx.coroutines.launch

private val client = HttpClient(Android)
private val service = ApiServiceImpl(client)

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
                    service.sendNotification(
                        title = title,
                        description = description
                    )
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
