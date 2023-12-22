package com.aa.ui.screens.phase_3.navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screens.phase_1.ai_state_screen.navigateToAiStateScreen
import com.aa.ui.screens.phase_1.statescreen.navigateToStateScreen
import com.aa.ui.screens.phase_3.kids_discover_screen.navigateToKidsDiscoverScreen
import com.aa.ui.screens.phase_3.home_screen.navigateToHomeKidsScreen

@Composable
fun NavigationBarKids(
    navController: NavController,
    modifier: Modifier = Modifier,
    selectedIcon: NavItemKids = NavItemKids.Home
) {
    NavigationBarKidsContent(
        onHomeClick = {
            navController.navigateToHomeKidsScreen()
        },
        onDiscoverClick = {
            navController.navigateToKidsDiscoverScreen()
        },
        onChatBotClick = {
                         navController.navigateToAiStateScreen()
        },
        onStateClick = {
                       navController.navigateToStateScreen()
        },
        onProfileClick = {},
        modifier = modifier,
        selectedIcon = selectedIcon
    )
}

@Composable
private fun NavigationBarKidsContent(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onDiscoverClick: () -> Unit = {},
    onChatBotClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onStateClick : () -> Unit = {},
    selectedIcon : NavItemKids = NavItemKids.Home
) {
    var item by remember { mutableStateOf(selectedIcon) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .border(
                width = 0.5.dp,
                color = Color(0xFFCDCDD0),
                shape = RoundedCornerShape(size = 64.dp)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 64.dp))
            .padding(horizontal = 24.dp)
    ) {
        NavigationBarKidsItem(
            iconRes = R.drawable.home_button,
            contentDescription = "home",
            onClick = {
                onHomeClick()
                item = NavItemKids.Home
            },
            isSelected = item == NavItemKids.Home
        )
        NavigationBarKidsItem(
            iconRes = R.drawable.discover24,
            contentDescription = "discover",
            onClick = {
                onDiscoverClick()
                item = NavItemKids.Discover
            },
            isSelected = item == NavItemKids.Discover
        )
        Box(
            modifier = Modifier
                .size(48.dp)
                .clickable {onStateClick()}
                .clip(shape = CircleShape)
                .background(Brush.linearGradient(listOf(Color(0xFFF15223), Color(0xFFE3524F))))
                .shadow(
                    elevation = 68.dp,
                    spotColor = Color(0x0F232C5D),
                    ambientColor = Color(0x0F232C5D)
                )
        )
        NavigationBarKidsItem(
            iconRes = R.drawable.message_bot,
            contentDescription = "chat bot",
            onClick = {
                onChatBotClick()
                item = NavItemKids.ChatBot
            },
            isSelected = item == NavItemKids.ChatBot
        )

        NavigationBarKidsItem(
            iconRes = R.drawable.profile_button,
            contentDescription = "profile",
            onClick = {
                onProfileClick()
                item = NavItemKids.Profile
            },
            isSelected = item == NavItemKids.Profile
        )
    }
}

@Composable
private fun NavigationBarKidsItem(
    iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    Surface(
        modifier = Modifier
            .size(28.dp)
            .clip(CircleShape)
            .clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = if (isSelected) Color(0xFFF15223) else Color.LightGray
        )
    }
}

enum class NavItemKids {
    Home,
    Discover,
    ChatBot,
    Profile,
}

@Preview
@Composable
fun NavigationBarKisPreview() {
    NavigationBarKidsContent()
}
