package com.aa.ui.screens.phase_1.search.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.draw.shadow
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
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClicked: () -> Unit,
    endIcon: @Composable (() -> Unit)? = null,
){
    Box(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 12.dp)
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .background(color = Color(0xFFaFFFFF), shape = RoundedCornerShape(size = 16.dp))
            .shadow(
                elevation = 68.dp,
                spotColor = Color(0x0F232C5D),
                ambientColor = Color(0x0F232C5D)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFEAECF0),
                shape = RoundedCornerShape(size = 16.dp)
            )
    )
    {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFaFFFFF), shape = RoundedCornerShape(size = 16.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFFEAECF0),
                    shape = RoundedCornerShape(size = 16.dp)
                ),
            value = query,
            onValueChange = {
                onQueryChange(it)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFFFFFFF),
                unfocusedTrailingIconColor = Color.Unspecified,
                focusedIndicatorColor = Color(0xFFEAECF0),
                disabledTrailingIconColor = Color.Unspecified ,
                focusedTrailingIconColor = Color.Unspecified,
            ),
            placeholder = {
                Text(
                    text = "search",
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
            trailingIcon = {
                    Icon(
                        painter  = painterResource(id = R.drawable.search),
                        contentDescription = "search icon"
                    )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked()
                }
            )
        )
    }
}


@Composable
@Preview
fun SearchBarPreview(){
    SearchBar(query = "",
        onQueryChange = {},
        onSearchClicked = {},
    )
}