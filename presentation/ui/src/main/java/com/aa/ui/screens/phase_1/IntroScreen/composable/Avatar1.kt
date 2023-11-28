
package com.aa.ui.screens.phase_1.IntroScreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.aa.ui.theme.AvatarSize
import com.aa.ui.theme.LinearGradiantWidth
import com.aa.ui.theme.LinearGradientHeight

@Composable
fun Avatar1(painterAv: Painter,painterLi: Painter){
    Box(
        modifier=Modifier.fillMaxSize()

    ){
        Image(
            painter = painterLi,
            contentDescription = "D",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(width = LinearGradiantWidth , height = LinearGradientHeight )

        )
        Image(
            painter =painterAv,
            contentDescription = "D",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(AvatarSize)

        )
    }

    }

