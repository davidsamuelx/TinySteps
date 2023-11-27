package com.aa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aa.ui.R

private val Montserrat= FontFamily(
    Font(R.font.montserrat_regular,FontWeight.W400),
    Font(R.font.montserrat_medium,FontWeight.W500),
    Font(R.font.montserrat_semibold,FontWeight.W600),
    Font(R.font.montserrat_bold,FontWeight.W700)

)
val Nunito= FontFamily(
    Font(R.font.nunito_bold,FontWeight.W700)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val montserrat= FontFamily(
    Font(R.font.montserrat_regular,FontWeight.Normal),
    Font(R.font.montserrat_medium,FontWeight.Medium),
    Font(R.font.montserrat_semibold,FontWeight.SemiBold),
    Font(R.font.montserrat_bold,FontWeight.Bold)

)
object Type{
    val Caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = textSize40,
        letterSpacing = textSizeMinus1
    )
    val Title =TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = textSize14,
        letterSpacing = textSizeMinus1
    )
    val TextButton=TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = textSize14,
        letterSpacing = textSize0
    )
    val subtitle=TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = textSize12,
        letterSpacing = textSize0
    )
    val TitleAppBar = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = textSize24,
        letterSpacing = textSizeMinus1
    )
    val TitleTextField = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = textSize10,
        letterSpacing = textSize1
    )
    val SubtitleTextField = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = textSize18,
        letterSpacing = textSize0

    )
    val ForgetPassword = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = textSize14,
        letterSpacing = textSize0

    )
    val TitleState = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize18,
        letterSpacing = textSize0
    )
    val SubtitleHeader=TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = textSize14,
        letterSpacing = textSize0
    )
    val HomeTitle=TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize20,
        letterSpacing = textSize0
    )
    val ChatBotText=TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Bold,
        fontSize = textSize13,
        letterSpacing = textSize0
    )
    val HealthCondition=TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = textSize16,
        letterSpacing = textSize0
    )

}