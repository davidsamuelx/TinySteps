package com.aa.ui.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.aa.ui.theme.BackgroundOrangeColor
import com.aa.ui.theme.BigButtonHugHeight
import com.aa.ui.theme.BigFixedWidth345
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.space16
import com.aa.ui.theme.space160
import com.aa.ui.theme.space24
import com.aa.ui.theme.space36
import com.aa.ui.theme.space8

@Composable
fun NextButton(
    textButton:String,
    onClickNext:()->Unit,
){

    Card(
        modifier = Modifier
            .clickable(onClick = onClickNext)
            .size(
                width = BigFixedWidth345,
                height = BigButtonHugHeight
            )
,
        shape = RoundedCornerShape(space24),

        ) {
        Row(
            Modifier
                .background(BackgroundOrangeColor)
                .size(
                    width = BigFixedWidth345,
                    height = BigButtonHugHeight
                ).align(CenterHorizontally),

            ) {

            HorizontalSpacer(space = space160)
        Text(
            text =textButton,
            color = PrimaryTextColor,
            style =  Type.TextButton,
            modifier = Modifier.align(Alignment.CenterVertically)

        )

}

}
}
