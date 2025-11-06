package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.GetProBG
import com.arjesh.boxboxassignment.theme.HeaderBG
import com.arjesh.boxboxassignment.theme.MonteserratFonts

@Composable
fun GetPro(
    modifier: Modifier = Modifier,
    showBackground: Boolean,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (showBackground) HeaderBG else Color.Transparent,
    )
    Box(
        modifier
            .fillMaxWidth()
            .background(animatedColor)
            .padding(vertical = 20.dp, horizontal = 20.dp),
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .background(
                    color = GetProBG,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.img_diamond),
                modifier = Modifier.size(18.dp),
                contentDescription = null,
            )
            Spacer(Modifier.width(5.dp))
            Text(
                text = stringResource(R.string.get_pro),
                fontSize = 14.sp,
                fontFamily = MonteserratFonts,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}