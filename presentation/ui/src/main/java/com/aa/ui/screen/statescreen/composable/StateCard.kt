package com.aa.ui.screen.statescreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.aa.ui.theme.FirstStateNumberHeight
import com.aa.ui.theme.FirstStateNumberWidth
import com.aa.ui.theme.IconStateHeight
import com.aa.ui.theme.IconStateWidth
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.ShapeStateAppBarWidth344
import com.aa.ui.theme.ShapeStateHeight
import com.aa.ui.theme.StateFrameSize
import com.aa.ui.theme.Type
import com.aa.ui.theme.background
import com.aa.ui.theme.space16
import com.aa.ui.theme.space24
import com.aa.ui.theme.space8

@Composable
fun StateCard(
    phase:Painter,
    title:String,
    phaseNumber:Painter,
    onClick:()->Unit
) {
    Card(
        modifier = Modifier.padding(horizontal = space24, vertical = space8)
            .size(
                width = ShapeStateAppBarWidth344,
                height = ShapeStateHeight
            )
            .clickable(onClick = onClick)
        ,

        shape = RoundedCornerShape(space24),
    ) {
        Row(
            Modifier
                .background(background)
                .width(ShapeStateAppBarWidth344)
                .padding(space24),
                Arrangement.SpaceBetween

        ) {

            Column(
                Modifier
                    .height(ShapeStateHeight)
            ,
                Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier.size(StateFrameSize),
                    shape = RoundedCornerShape(space16)
                ) {
                    Image(
                        painter = phase,
                        contentDescription = "phase 1",
                        Modifier
                            .size(
                                width = IconStateWidth, height = IconStateHeight
                            )
                            .align(Alignment.CenterHorizontally)

                    )

                }
                Text(
                    text = title,
                    color = PrimaryTextColor,
                    style = Type.TitleState,
                )

            }

            Image(phaseNumber ,
                contentDescription = "one",
                modifier=Modifier.size(width= FirstStateNumberHeight,
                    height = FirstStateNumberWidth
                )
            )
        }

    }

}
