package com.aa.ui.screens.chat_bot_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R

@Composable
fun ResponseItem(
    text : String,
    modifier: Modifier = Modifier
) {

    Column{
        Box(
            modifier = modifier
                .padding(start = 24.dp)
                .background(
                    color = Color(0xFFFEEEE9),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomEnd = 24.dp)
                )

                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF505050),
                ),
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(
            modifier = Modifier
                .shadow(
                    elevation = 2.dp,
                    spotColor = Color(0x0D000000),
                    ambientColor = Color(0x0D000000)
                )
                .size(26.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = CircleShape
                )
        ){
            Image(
                painter = painterResource(id = R.drawable.bot),
                contentDescription = "bot",
                modifier = Modifier.align(Alignment.Center)
                    .size(16.dp)
            )
        }

    }


}

@Preview
@Composable
fun ResponseItemPreview() {
    ResponseItem(text = "Hello,i’m fine,how can i help you?")
}