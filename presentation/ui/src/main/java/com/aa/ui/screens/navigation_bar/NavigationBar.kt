package com.aa.ui.screens.navigation_bar

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
import com.aa.ui.screens.discover_screen.navigateToDiscoverScreen
import com.aa.ui.screens.home_screen.navigateToHomeScreen

@Composable
fun NavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    selectedIcon: NavItem = NavItem.Home
) {
    NavigationBarContent(
        onHomeClick = {
            navController.navigateToHomeScreen()
        },
        onDiscoverClick = {
            navController.navigateToDiscoverScreen()
        },
        onChatBotClick = {},
        onProfileClick = {},
        modifier = modifier,
        selectedIcon = selectedIcon
    )
}

@Composable
private fun NavigationBarContent(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onDiscoverClick: () -> Unit = {},
    onChatBotClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    selectedIcon : NavItem = NavItem.Home
) {
    // State to keep track of the selected icon
    var item by remember { mutableStateOf(selectedIcon) }

    Row(
        horizontalArrangement = Arrangement.Center,
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
        NavigationBarItem(
            iconRes = R.drawable.home_button,
            contentDescription = "home",
            onClick = {
                onHomeClick()
                item = NavItem.Home
            },
            isSelected = item == NavItem.Home
        )
        Spacer(modifier = Modifier.width(40.dp))
        NavigationBarItem(
            iconRes = R.drawable.discover24,
            contentDescription = "discover",
            onClick = {
                onDiscoverClick()
                item = NavItem.Discover
            },
            isSelected = item == NavItem.Discover
        )
        Spacer(modifier = Modifier.width(36.dp))
        Box(
            modifier = Modifier
                .size(48.dp)
                .clickable { /* Handle click if needed */ }
                .clip(shape = CircleShape)
                .background(Brush.linearGradient(listOf(Color(0xFFF15223), Color(0xFFE3524F))))
                .shadow(
                    elevation = 68.dp,
                    spotColor = Color(0x0F232C5D),
                    ambientColor = Color(0x0F232C5D)
                )
        )
        Spacer(modifier = Modifier.width(36.dp))

        NavigationBarItem(
            iconRes = R.drawable.message_bot,
            contentDescription = "chat bot",
            onClick = {
                onChatBotClick()
                item = NavItem.ChatBot
            },
            isSelected = item == NavItem.ChatBot
        )

        Spacer(modifier = Modifier.width(40.dp))

        NavigationBarItem(
            iconRes = R.drawable.profile_button,
            contentDescription = "profile",
            onClick = {
                onProfileClick()
                item = NavItem.Profile
            },
            isSelected = item == NavItem.Profile
        )
    }
}

@Composable
private fun NavigationBarItem(
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

enum class NavItem {
    Home,
    Discover,
    ChatBot,
    Profile
}

@Preview
@Composable
fun NavigationBarPreview() {
    NavigationBarContent()
}
