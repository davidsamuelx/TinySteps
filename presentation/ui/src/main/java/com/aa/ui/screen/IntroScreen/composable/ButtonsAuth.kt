package com.aa.ui.screen.IntroScreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.ui.R
import com.aa.ui.screen.composable.HorizontalSpacer
import com.aa.ui.screen.composable.VerticalSpacer
import com.aa.ui.theme.BigButtonHugHeight
import com.aa.ui.theme.BigFixedWidth345
import com.aa.ui.theme.CardButtonHeight
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.SecondaryTextColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.space16
import com.aa.ui.theme.space32
import com.aa.ui.theme.space4
import com.aa.ui.theme.space62
import com.aa.ui.theme.space72
import com.aa.ui.theme.space8


@Composable
fun ButtonsAuth(
    email:String,
    login: Painter,
    onClick:()->Unit
){

    Card(
        modifier = Modifier

            .size(
                width = BigFixedWidth345,
                height = BigButtonHugHeight
            )
            .padding(vertical = space8),

        shape = RoundedCornerShape(space16),

        ) {
                Row(
                    Modifier
                        .background(PrimaryTextColor)
                        .clickable (onClick = onClick)
                        .size(
                            width = BigFixedWidth345,
                            height = BigButtonHugHeight
                        ).align(CenterHorizontally),

                    ) {
                    HorizontalSpacer(space = space72)
                    Image(painter = login,
                        contentDescription = "s"
                        ,  modifier = Modifier.align(CenterVertically)
                    )
                    HorizontalSpacer(space = space4)
                    Text(
                        text = email,
                        color = SecondaryTextColor,
                        style =  Type.TextButton,
                        modifier = Modifier.align(CenterVertically)
                    )
                }

                

        }

        }


