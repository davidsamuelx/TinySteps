package com.aa.ui.screens.phase_1.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun HorizontalSpacer(space: Dp) {
    Spacer(modifier = Modifier.width(space))
}