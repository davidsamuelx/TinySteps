package com.aa.ui.screens.chat_bot_screen.composables

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ResponseItem(
    text: String,
    modifier: Modifier = Modifier
) {
    var longPressOffset by remember { mutableStateOf<Offset?>(null) }

    val context = LocalContext.current

    Column {
        Box(
            modifier = modifier
                .padding(start = 24.dp)
                .background(
                    color = Color(0xFFFEEEE9),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomEnd = 24.dp)
                )
                .align(Alignment.CenterHorizontally)
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, _, _ ->
                        if (pan != Offset(0f, 0f)) {
                            // Update the long press offset
                            longPressOffset = pan
                        }
                    }
                }
        ) {
            Box(
                modifier = Modifier.wrapContentSize(),
                content = {
                    if (text.isNotEmpty()) {
                        Text(
                            text = text,
                            style = LocalTextStyle.current.copy(
                                color = Color(0xFF505050),
                                fontWeight = FontWeight(700),
                                fontSize = 13.sp
                            ),
                            modifier = Modifier.padding(16.dp)
                                .combinedClickable(
                                    onLongClick = {
                                        // On long press, copy the text to the clipboard
                                        val clipboard =
                                            context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                        val clip =
                                            ClipData.newPlainText("label", text)
                                        clipboard.setPrimaryClip(clip)
                                        Toast.makeText(
                                            context,
                                            "Text copied to clipboard",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                    onClick = { /*....*/ }
                                )
                        )
                    }
                },
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
        ) {
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