package com.arjesh.boxboxassignment.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R


val SpaceGroteskFonts = FontFamily(
    Font(R.font.space_grotesk_light, FontWeight.Light),
    Font(R.font.space_grotesk_regular, FontWeight.Normal),
    Font(R.font.space_grotesk_medium, FontWeight.Medium),
    Font(R.font.space_grotesk_semibold, FontWeight.SemiBold),
    Font(R.font.space_grotesk_bold, FontWeight.Bold),
)

val MonteserratFonts = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_black, FontWeight.Bold),
)

val GothamFonts = FontFamily(
    Font(R.font.gotham_medium, FontWeight.Medium),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = SpaceGroteskFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    displayMedium = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    displaySmall = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    headlineLarge = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    headlineMedium = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    headlineSmall = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    titleLarge = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    titleMedium = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    titleSmall = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    bodyMedium = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    bodySmall = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    labelLarge = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    labelMedium = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
    labelSmall = TextStyle(
        fontFamily = SpaceGroteskFonts,
    ),
)

