package com.aa.ui.screens.phase_3.education.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R

@Composable
fun LetterCard(
    id: Int,
    modifier: Modifier = Modifier,
    image: String,
    onClickItem: (Int) -> Unit,
){
    Column(
        modifier = modifier.padding(end = 12.dp)
    ) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(140.dp)
            .clip(shape = RoundedCornerShape(size = 20.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFEAECF0),
                shape = RoundedCornerShape(size = 20.dp)
            )
            .clickable(onClick = { onClickItem(id) })
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEAECF0)),
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = image,
                    placeholder = painterResource(id = R.drawable.placeholde_image)

                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )

        }
    }
    }
}

@Preview
@Composable
private fun CardPreview() {
    LetterCard(
        id = 0,
        image = "",
        onClickItem = {}
    )
}