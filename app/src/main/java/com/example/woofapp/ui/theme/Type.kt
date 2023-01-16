package com.example.woofapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.woofapp.R

// Set of Material typography styles to start with
val AbrilFatFace = FontFamily(
 Font(R.font.abrilfatface_regular)
)
val Montserrat = FontFamily(
 Font(R.font.montserrat_regular),
 Font(R.font.montserrat_bold, FontWeight.Bold)
)

val Typography = Typography(
 h1 = TextStyle(
  fontFamily = AbrilFatFace,
  fontWeight = FontWeight.Normal,
  fontSize = 30.sp
 ),
 h2 = TextStyle(
  fontFamily = Montserrat,
  fontWeight = FontWeight.Bold,
  fontSize = 20.sp
 ),
 h3 = TextStyle(
  fontFamily = Montserrat,
  fontWeight = FontWeight.Bold,
  fontSize = 14.sp
 ),
 body1 = TextStyle(
  fontFamily = Montserrat,
  fontWeight = FontWeight.Normal,
  fontSize = 14.sp
 )
 )


 /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
