package com.aa.ui.screens.navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
    modifier: Modifier = Modifier
) {
    NavigationBarContent(
        onHomeClick = navController::navigateToHomeScreen,
        onDiscoverClick = navController::navigateToDiscoverScreen,
        modifier = modifier
    )
    
}
@Composable
private fun NavigationBarContent(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onDiscoverClick: () -> Unit = {},
    onChatBotClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    isClicked: Boolean = false,
    ) {

    val iconColor = if (isClicked) Color(0xFFF15223) else Color(0xffeaecf0)


    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .border(
                width = 0.5.dp,
                color = Color(0xFFCDCDD0),
                shape = RoundedCornerShape(size = 64.dp)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 64.dp))
            .padding(horizontal = 24.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.home_button),
            contentDescription = "home",
            tint = iconColor,
            modifier = Modifier
                .size(28.dp)
                .clickable { onHomeClick() }
        )
        Spacer(modifier = Modifier.width(40.dp))
        Icon(
            painter = painterResource(id = R.drawable.discover_button),
            contentDescription = "home",
            tint = iconColor,
            modifier = Modifier
                .size(28.dp)
                .clickable { onDiscoverClick()}
        )
        Spacer(modifier = Modifier.width(36.dp))
        Box(
            modifier = Modifier
                .size(48.dp)
                .clickable { }
                .clip(shape = CircleShape)
                .background(Brush.linearGradient(listOf(Color(0xFFF15223), Color(0xFFE3524F))))
                .shadow(
                    elevation = 68.dp,
                    spotColor = Color(0x0F232C5D),
                    ambientColor = Color(0x0F232C5D)
                )
        )
        Spacer(modifier = Modifier.width(36.dp))

        Icon(
            painter = painterResource(id = R.drawable.message_bot),
            contentDescription = "home",
            tint = iconColor,
            modifier = Modifier
                .size(28.dp)
                .clickable { }
        )

        Spacer(modifier = Modifier.width(40.dp))

        Icon(
            painter = painterResource(id = R.drawable.profile_button),
            contentDescription = "home",
            tint = iconColor,
            modifier = Modifier
                .size(28.dp)
                .clickable { }
        )

    }
}

@Preview
@Composable
fun NavigationBarPreview() {
    NavigationBarContent(isClicked = false)
}