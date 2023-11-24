package com.aa.ui.screen.IntroScreen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.aa.ui.screen.composable.VerticalSpacer
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.SubTitleHeight
import com.aa.ui.theme.SubtitleColor
import com.aa.ui.theme.TitleHeight
import com.aa.ui.theme.Type
import com.aa.ui.theme.WriteFrameWidth
import com.aa.ui.theme.space24
import com.aa.ui.theme.space32
import com.aa.ui.theme.space8
import com.aa.ui.theme.textSize40

@Composable
fun TitleText(title:String,subtitle:String){
    Column {
        VerticalSpacer(space = space32)
        Text(
            modifier = Modifier.size(
                width = WriteFrameWidth,
                height = TitleHeight
            ),
            text = title,
            color = PrimaryTextColor,
            style= Type.Caption,
        )
        VerticalSpacer(space = space8)
        Text(
            modifier = Modifier.size(
                width = WriteFrameWidth,
                height = SubTitleHeight
            ),
            text = subtitle,
            color = SubtitleColor,
            style= Type.Title,
        )
    }

}
@Preview
@Composable
fun PreviewText(){
    TitleText("Lorem ipsum is placeholder.",
        "Lorem ipsum is placeholder text commonly used in the graphic")
}