package com.aa.viewmodels.chat_bot_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.open_ai.Message
import com.aa.models.open_ai.OpenAIRequestEntity
import com.aa.models.open_ai.OpenAIResponseEntity
import com.aa.usecase.open_ai.GetOPenAIResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatBotViewModel @Inject constructor(
    private val getOPenAIResponseUseCase: GetOPenAIResponseUseCase
) : BaseViewModel<ChatBotUiState>(ChatBotUiState()) {

    fun onQueryChange(query: CharSequence) {
        _state.update {
            it.copy(
                query = query.toString(),
            )
        }
    }

    fun onSendMessageClicked() {
        val userMessage = _state.value.query
        _state.update { it.copy(messageRequest = _state.value.messageRequest + userMessage ) }
        if (userMessage.isNotEmpty()) {
            _state.update { it.copy(isLoading = true, query = "",messages = it.messages + listOf(userMessage)) }
            tryToExecute(
                { getOPenAIResponseUseCase(_state.value.toEntity()) },
                ::onSendMessageSuccess ,
                ::onError
            )
        }
    }

    private fun onSendMessageSuccess(response: OpenAIResponseEntity) {
        val aiMessages = response.choices.map { it.text }
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = false,
                query = "", // Clear the user query after sending
                messages = state.messages + aiMessages
            )
        }
    }

    private fun onError(error: BaseErrorUiState) {
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = true,
                error = error
            )
        }
    }
}

fun ChatBotUiState.toEntity(): OpenAIRequestEntity {
    return OpenAIRequestEntity(
        model = model,
        message = messageRequest.map {
            Message(
                role = "user",
                content = it
            )
        }
    )
}
