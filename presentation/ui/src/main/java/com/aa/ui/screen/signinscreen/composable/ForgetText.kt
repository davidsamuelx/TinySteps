package com.aa.ui.screen.signinscreen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.aa.ui.R
import com.aa.ui.theme.ForgetTextHeight
import com.aa.ui.theme.SecondHintTextColor
import com.aa.ui.theme.ShapeStateAppBarWidth344
import com.aa.ui.theme.SubtitleColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.Type.ForgetPassword
import com.aa.ui.theme.WriteFrameWidth
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
