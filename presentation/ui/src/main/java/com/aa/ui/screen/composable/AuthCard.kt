package com.aa.ui.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R
import com.aa.ui.theme.PrimaryHintTextColor
import com.aa.ui.theme.PrimaryTextColor
import com.aa.ui.theme.SecondaryTextColor
import com.aa.ui.theme.TextFieldHugHeight72
import com.aa.ui.theme.Type
import com.aa.ui.theme.space0
import com.aa.ui.theme.space122
import com.aa.ui.theme.space16
import com.aa.ui.theme.space160
import com.aa.ui.theme.space24
import com.aa.ui.theme.space4
import com.aa.ui.theme.space62
import com.aa.ui.theme.space8

@Composable
fun AuthCard(
    title:String,
    email:String,
    onTextChanged:(String)->Unit,
    onTextDelete:()->Unit,

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
        Row {
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

    }


}