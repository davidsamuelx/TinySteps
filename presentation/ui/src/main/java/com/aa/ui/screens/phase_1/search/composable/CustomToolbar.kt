package com.aa.ui.screens.phase_1.search.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aa.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbar(
    navController: NavController,
    title: String
){
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = Color(0xFF040415)
        ),
        title =
        {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF040415),
                )
            )
        },
        modifier = Modifier.background(Color(0xFFFFFFFF)),
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .padding(12.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEAECF0),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .clip(RoundedCornerShape(size = 16.dp)),
                onClick = { navController.navigateUp() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_arrow_back_ios_24),
                    contentDescription = "back"
                )
            }
        }

    )
}

@Composable
@Preview
fun ToolBarPreview(){
    val navController = rememberNavController()
   CustomToolbar(navController = navController, title = "Nutrition" )
}