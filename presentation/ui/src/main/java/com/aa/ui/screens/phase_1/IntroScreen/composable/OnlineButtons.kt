package com.aa.ui.screens.phase_1.IntroScreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.aa.ui.screens.phase_1.composable.HorizontalSpacer
import com.aa.ui.theme.BigButtonHugHeight
import com.aa.ui.theme.BigFixedWidth345
import com.aa.ui.theme.EmailsButtonHeight
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.SecondaryTextColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.space36
import com.aa.ui.theme.space4

@Composable
fun  OnlineButtons(email:String,logo:Painter){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(EmailsButtonHeight)
            ,
        shape = RoundedCornerShape(16.dp),

        ) {
        Row(
            Modifier
                .clickable {  }
                .background(PrimaryTextColor)
                .size(
                    width = BigFixedWidth345,
                    height = BigButtonHugHeight
                )
                .align(Alignment.Start),

            ) {
            HorizontalSpacer(space = space36)
            Image(painter = logo,
                contentDescription = "s"
                ,  modifier = Modifier.align(Alignment.CenterVertically)
            )
            HorizontalSpacer(space = space4)
            Text(
                text = email,
                color = SecondaryTextColor,
                style =  Type.TextButton,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

    }

}




