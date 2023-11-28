package com.aa.ui.screens.phase_1.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.aa.ui.R
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.SecondaryTextColor
import com.aa.ui.theme.TextFieldHugHeight72
import com.aa.ui.theme.Type
import com.aa.ui.theme.space16
import com.aa.ui.theme.space160
import com.aa.ui.theme.space24
import com.aa.ui.theme.space8

@Composable
fun AuthCard(
    title:String,
    email:String,
    onTextChanged:(String)->Unit,
    onTextDelete:()->Unit,
   error: String? = null

) {
    val isTextEmpty = email.isEmpty()
    Column(
        modifier =
        Modifier
            .padding(space16, space8)
            .background(PrimaryTextColor)
            .fillMaxWidth()
            .height(TextFieldHugHeight72)
    )
    {
        Text(
            text = title,
            style = Type.TitleTextField,
            color = SecondaryTextColor,
            modifier = Modifier.padding(space8)

        )
        Row() {
            HorizontalSpacer(space = space8)

            BasicTextField(
                value = email,
                onValueChange = onTextChanged,
                textStyle = Type.SubtitleTextField,
                modifier = Modifier.background(PrimaryTextColor),

                )

            HorizontalSpacer(space = space160)
            if (!isTextEmpty) {
                IconButton(
                    onClick = onTextDelete,
                    modifier = Modifier.padding(bottom = space24)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.remove_cr_fr),
                        contentDescription = "Deleter"
                    )

                }
            }
        }
        if (!error.isNullOrBlank()) {
            // Display the error message if it exists
            Log.d("Auth", "Error: $error")

            Text(
                text = error,
                color = Color.Red,
                modifier = Modifier.padding(start = space8, bottom = space24)
            )
        }
    }


}