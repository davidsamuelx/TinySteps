package com.aa.ui.screen.IntroScreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aa.ui.R
import com.aa.ui.screen.composable.HorizontalSpacer
import com.aa.ui.theme.DotsHeight
import com.aa.ui.theme.DotsWidth
import com.aa.ui.theme.space116
import com.aa.ui.theme.space62

@Composable
fun Dots(painter: Painter){
    Row {
        HorizontalSpacer(space = space62)
        Image(
            painter = painter,
            contentDescription = "Dots",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(width = DotsWidth, height = DotsHeight)

        )
    }

}
@Preview
@Composable
fun PreviewScreen(){
    Dots(painter = painterResource(id = R.drawable.dots))
}