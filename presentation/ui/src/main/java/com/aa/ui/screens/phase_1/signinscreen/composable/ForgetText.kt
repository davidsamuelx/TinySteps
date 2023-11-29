package com.aa.ui.screens.phase_1.signinscreen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.aa.ui.theme.Type
import com.aa.ui.theme.space16

@Composable
fun ForgetText(
             text:String,
             textAlign: TextAlign,
             textColor:Color,
             onClick:()->Unit
               ){
    Text(

        text = text,
        color = textColor,
        style = Type.ForgetPassword,
        modifier = Modifier
            .clickable(onClick=onClick)
            .padding(space16),
        textAlign = textAlign,
    )
}
