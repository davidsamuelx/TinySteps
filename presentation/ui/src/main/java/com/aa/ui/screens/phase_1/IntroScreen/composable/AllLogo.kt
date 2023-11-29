package com.aa.ui.screens.phase_1.IntroScreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.aa.ui.screens.phase_1.composable.HorizontalSpacer
import com.aa.ui.screens.phase_1.composable.VerticalSpacer
import com.aa.ui.theme.space100
import com.aa.ui.theme.space116
import com.aa.ui.theme.space208
import com.aa.ui.theme.space294
import com.aa.ui.theme.space32
import com.aa.ui.theme.space56
import com.aa.ui.theme.space86

@Composable
fun AllLogo(
    avatar1:Painter,
    avatar2:Painter,
    avatar3:Painter,
    avatar4:Painter,
    gradiant1:Painter,
    gradient2:Painter,
    state:Painter
    ){

        Box {
            Column {
                VerticalSpacer(space = space86)
                Image(
                    painter = state,
                    contentDescription = "D",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Column {
                VerticalSpacer(space = space32)
                Row {
                    HorizontalSpacer(space = space32)

                    Avatar1(painterAv =avatar1
                        , painterLi = gradiant1 )
                    HorizontalSpacer(space = space100)
                }
            }

            Column {
                VerticalSpacer(space = space56)
                Row {
                    HorizontalSpacer(space116)
                    Avatar2(painterAv = avatar2,
                        painterLi = gradient2 )
                }

            }
            Row {
                HorizontalSpacer( space208)
                Avatar1(
                    painterAv = avatar3 ,
                    painterLi = gradiant1)
            }
            Row {
                HorizontalSpacer(space = space294)
                Avatar2(
                    painterAv = avatar4 ,
                    painterLi =gradient2)
            }


        }


}
