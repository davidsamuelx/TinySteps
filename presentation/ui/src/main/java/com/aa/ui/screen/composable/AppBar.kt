package com.aa.ui.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.ui.R
import com.aa.ui.theme.DotsWidth
import com.aa.ui.theme.PrimaryHintTextColor
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.Type
import com.aa.ui.theme.White
import com.aa.ui.theme.space16
import com.aa.ui.theme.space2
import com.aa.ui.theme.space4

@Composable
fun AppBar(
  modifier:Modifier=Modifier,
    onClick:()->Unit,
  titleAppBar:String,
  backPainter: Painter
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
            Image(painter = backPainter,
                contentDescription = "asd"
                ,
                modifier
                    .padding(space16)
                    .clickable(onClick = onClick)
            )

        Text(
            modifier = Modifier.padding(vertical = space4),
            text =titleAppBar ,
            style = Type.TitleAppBar,
            textAlign = TextAlign.Center
        )
    }

    }
@Preview(showBackground = true)
@Composable
fun PreviewAppBar(){
    AppBar(onClick = { /*TODO*/ }, titleAppBar ="asd" ,
        backPainter = painterResource(id = R.drawable.left_icon) )
}
