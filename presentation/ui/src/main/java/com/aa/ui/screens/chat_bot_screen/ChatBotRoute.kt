package com.aa.ui.screens.chat_bot_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.ChatBotScreen


fun NavController.navigateToChatBotScreen() {
    navigate(ROUTE)
}

fun NavController.backToChatBotScreen() {
    popBackStack()
}

fun NavGraphBuilder.chatBotScreen(navController: NavHostController) {
    composable(ROUTE) { ChatBotScreen(navController) }
}