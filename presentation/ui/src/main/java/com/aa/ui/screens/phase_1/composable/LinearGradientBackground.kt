package com.aa.ui.screens.phase_1.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.aa.ui.theme.PrimaryColor
import com.aa.ui.theme.SecondaryColor


@Composable
fun LinearGradientBackground(){
    val background=Brush.linearGradient(
        0.0f to PrimaryColor,
        500.0f to SecondaryColor,
        start = Offset.Zero,
        end=Offset.Infinite
    )
}