package com.aa.ui.screens.phase_1.statescreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.aa.ui.theme.DotsWidth
import com.aa.ui.theme.PrimaryHintTextColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.White
import com.aa.ui.theme.space16
import com.aa.ui.theme.space2

@Composable
fun AppBarState(
  modifier:Modifier=Modifier,
  titleAppBar:String,
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(DotsWidth)
            .background(White)
            .border(space2, color = PrimaryHintTextColor )
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Text(
            modifier = Modifier.padding(horizontal = space16),
            text =titleAppBar ,
            style = Type.TitleAppBar,
            textAlign = TextAlign.Center

        )
    }

    }

