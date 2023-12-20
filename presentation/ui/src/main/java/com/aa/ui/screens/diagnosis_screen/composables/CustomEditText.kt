package com.aa.ui.screens.diagnosis_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    query : String,
    onQueryChange: (String) -> Unit,
    hint : String,
    plusClick : () -> Unit = {},
    plusVisibility : Boolean
) {
    Box (
        modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                width = 1.dp,
                color = Color(0x90AFADAD),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .fillMaxWidth()
            .height(58.dp)

    )
    {
        if (plusVisibility)
        TextField(
            value = query,
            onValueChange = {
                onQueryChange(it)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White)
                .fillMaxWidth()


            ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFFFFFFF),
                focusedIndicatorColor = Color(0xFFEAECF0),
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                disabledTextColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = "Symptoms $hint",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF9B9BA1),
                    )
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = Color.Black
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send
            ),
            trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.plus_icon),
                        contentDescription = "Plus Icon",
                        tint = Color(0Xffff3a00),
                        modifier = Modifier.padding(end = 2.dp).clickable { plusClick() }

                    )
            }

        )else {
            TextField(
                value = query,
                onValueChange = {
                    onQueryChange(it)
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White)
                    .fillMaxWidth()


                ,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor = Color(0xFFEAECF0),
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Symptoms $hint",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF9B9BA1),
                        )
                    )
                },
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = Color.Black
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send
                ),
            )
        }
    }

}

@Preview
@Composable
fun PreviewCustomEditText() {
    CustomTextField(query = "", onQueryChange = {}, hint = "1" , plusVisibility = true )
}