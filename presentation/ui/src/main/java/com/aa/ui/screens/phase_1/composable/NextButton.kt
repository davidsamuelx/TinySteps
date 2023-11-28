package com.aa.ui.screens.phase_1.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.aa.ui.theme.BackgroundOrangeColor
import com.aa.ui.theme.BigButtonHugHeight
import com.aa.ui.theme.BigFixedWidth345
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.space160
import com.aa.ui.theme.space24


@Composable
fun NextButton(
    textButton:String,
    onClickNext:()->Unit,
    onClickSave:()->Unit
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
