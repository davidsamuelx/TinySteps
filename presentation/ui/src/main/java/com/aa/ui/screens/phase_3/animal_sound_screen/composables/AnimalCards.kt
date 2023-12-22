package com.aa.ui.screens.phase_3.animal_sound_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnimalCards(
    id: Int,
    modifier: Modifier = Modifier,
    image: String,
    sound: String,
    selectedId: Int,
    onCardSelected: (Int) -> Unit
) {
    val borderColor = if (id == selectedId) Color.Green else Color.Transparent

    Box(
        modifier = modifier
            .selectable(
                selected = (id == selectedId),
                onClick = { onCardSelected(id) }
            )
            .width(168.dp)
            .height(146.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE5E5E5))
            .border(2.dp, borderColor, RoundedCornerShape(16.dp))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview
@Composable
fun AnimalCardsPreview() {
    AnimalCards(
        id = 1,
        image = "",
        sound = "",
        selectedId = 1,
        onCardSelected = {}
    )
}