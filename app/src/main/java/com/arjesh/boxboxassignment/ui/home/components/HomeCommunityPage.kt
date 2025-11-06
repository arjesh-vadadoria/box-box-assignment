package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.Lime
import com.arjesh.boxboxassignment.theme.ListElementPadding
import com.arjesh.boxboxassignment.theme.MonteserratFonts

@Composable
fun HomeCommunityPage(
    modifier: Modifier,
    onFollowButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            ListElementPadding,
            alignment = Alignment.CenterVertically
        )
    ) {
        Image(
            painter = painterResource(R.drawable.img_join_community),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 52.dp),
            contentDescription = "join our community"
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Lime,
            ),
            onClick = {
                onFollowButtonClick()
            }) {
            Text(
                text = stringResource(R.string.follow_us),
                fontWeight = FontWeight.Bold,
                fontFamily = MonteserratFonts,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
