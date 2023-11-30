package com.aa.ui.screens.phase_1.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_1.search.composable.DoctorInfoText

@Composable
fun DetailsContent(
    navController: NavController,
    imageUrl: String,
    titleName: String,
    details: String,
    doctorName: String,
    doctorLocation: String,
    doctorNumber: String,
    problemName: String,
    problemSolve: String,
){
    val scrollState = rememberScrollState()

    Surface {

        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {

           CustomToolbar(navController = navController, title = "")

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F9FF))
                    .verticalScroll(state = scrollState),

                horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Image(
                    painter = rememberAsyncImagePainter(
                        model=imageUrl,
                        placeholder = painterResource(id = R.drawable.placeholde_image)),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(250.dp),
                )
                Text(
                    text = titleName,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 24.dp, top = 16.dp, bottom = 12.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
                Text(
                    text = details,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
                Text(
                    text = "Doctor Advice",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 24.dp, top = 32.dp, bottom = 12.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
                DoctorInfoText(title = "Name", text = doctorName )
                Spacer(modifier = Modifier.height(4.dp))
                DoctorInfoText(title = "Location", text = doctorLocation )
                Spacer(modifier = Modifier.height(4.dp))
                DoctorInfoText(title = "Number", text = doctorNumber)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = problemName,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 24.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = problemSolve,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun DetailsPreview() {
    val navController = rememberNavController()
    DetailsContent(navController = navController , imageUrl = "" , "", "", "", "", "","", "")
}