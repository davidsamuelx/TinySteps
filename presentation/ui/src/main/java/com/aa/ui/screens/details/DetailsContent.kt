package com.aa.ui.screens.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.aa.ui.R
import com.aa.ui.screens.search.composable.CustomToolbar
import com.aa.ui.screens.search.composable.DoctorInfoText

@Composable
fun DetailsContent(
    navController: NavController,
    imageUrl: String,
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
                    painter = painterResource(id = R.drawable.bananass),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(232.dp)
                )
                Text(
                    text = "Banana",
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
                    text = "A banana is an elongated, edible fruit – botanically a berry[1][2] – produced by several kinds of large herbaceous flowering plants in the genus Musa.[3] In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas. The fruit is variable in size, color, and firmness, but is usually elongated and curved, with soft flesh rich in starch covered with a rind, which may be green, yellow, red, purple, or brown when ripe. The fruits grow upward in clusters near the top of the plant. Almost all modern edible seedless (parthenocarp) bananas come from two wild species – Musa acuminata and Musa balbisiana. The scientific names of most cultivated bananas are Musa acuminata, Musa balbisiana, and Musa × paradisiaca for the hybrid Musa acuminata × M. balbisiana, depending on their genomic constitution. The old scientific name for this hybrid, Musa sapientum, is no longer used." ,
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
                DoctorInfoText(title = "Name", text = "Ahmed" )
                Spacer(modifier = Modifier.height(4.dp))
                DoctorInfoText(title = "Location", text = "Egypt, Cairo" )
                Spacer(modifier = Modifier.height(4.dp))
                DoctorInfoText(title = "Number", text = "+2012011806442")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Chronic Health Conditions",
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
                    text = "Raw or Undercooked Meat and Eggs: Undercooked or raw meat and eggs can carry harmful bacteria like Salmonella and E. coli, which can cause foodborne illnesses. Make sure all meat and eggs are thoroughly cooked before consumption",
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
    DetailsContent(navController = navController , imageUrl = "")
}