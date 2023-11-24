package com.aa.ui.screens.chat_bot_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.ai_state_screen.backToAiStateScreen
import com.aa.ui.screens.chat_bot_screen.composables.AskItem
import com.aa.ui.screens.chat_bot_screen.composables.ChatTextField
import com.aa.ui.screens.chat_bot_screen.composables.ResponseItem
import com.aa.ui.screens.details_screen.composables.CustomHeader
import com.aa.viewmodels.chat_bot_screen.ChatBotUiState
import com.aa.viewmodels.chat_bot_screen.ChatBotViewModel

@Composable
fun ChatBotScreen(
    navController: NavController,
    viewModel: ChatBotViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    ChatBotScreenContent(
        state = state,
        onQueryChange = viewModel::onQueryChange,
        onSendMessageClicked = viewModel::onSendMessageClicked,
          onBackClicked = navController::backToAiStateScreen
    )

}

@Composable
private fun ChatBotScreenContent(
    state: ChatBotUiState,
    onQueryChange: (String) -> Unit,
    onSendMessageClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomHeader(onBackClicked = {onBackClicked()}, text = "Chat Bot")
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),  // Take up all available space
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state.messages.size) { index ->
                val message = state.messages[index]
                if (index % 2 != 0) {
                    ResponseItem(text = message)
                } else {
                    AskItem(text = message)
                }
            }
            Log.i("ejaekae", state.messages.toString())
        }

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = Color(0xFFFF3A00),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .size(28.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)

        ) {
            ChatTextField(
                query = state.query,
                onQueryChange = onQueryChange,
                onSendClicked = onSendMessageClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}






@Preview
@Composable
fun ChatBotScreenPreview() {
    ChatBotScreenContent(state = ChatBotUiState() ,{},{}){}
}