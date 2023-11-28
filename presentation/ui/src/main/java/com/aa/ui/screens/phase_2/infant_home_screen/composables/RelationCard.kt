package com.aa.ui.screens.phase_2.infant_home_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RelationCard(
    modifier: Modifier = Modifier,
    text: String,
    title: String,
    id: Int,
    onCardClick: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .clickable { onCardClick(id) }
            .width(232.dp)
            .height(156.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFF8865), Color(0xFFFF3A00))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = title,
                maxLines = 1,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                ),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                ),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview
@Composable
private fun RelationCardPreview() {
    RelationCard(
        text = "Relation",
        title = "Effective Communication:Open and honest communication is key. Share your thoughts, concerns, and feelings with each other. Listen actively and avoid blame or criticism.",
        id = 0,
        onCardClick = {}
    )
}