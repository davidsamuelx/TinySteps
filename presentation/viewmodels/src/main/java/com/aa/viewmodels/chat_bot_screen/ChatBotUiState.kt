package com.aa.viewmodels.chat_bot_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState

data class ChatBotUiState
(
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null,
    val isError: Boolean = false,
    val messages: List<String> = emptyList(),
    val messageRequest : List<String> = emptyList(),
    val query: String = "",
    val model: String = "gpt-3.5-turbo"
): BaseUiState

