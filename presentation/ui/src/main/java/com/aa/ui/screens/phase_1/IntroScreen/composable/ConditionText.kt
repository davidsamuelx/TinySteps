package com.aa.ui.screens.phase_1.IntroScreen.composable


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.aa.ui.theme.ConditionColor
import com.aa.ui.theme.Type

@Composable
fun ConditionText(condtion:String

){
    Column {
        Text(
            modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally),
            text = condtion
            , style = Type.subtitle
            , color = ConditionColor,
            textAlign = TextAlign.Center
        )
    }


}