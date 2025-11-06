package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.HomeCardCornerRadiusRegular
import com.arjesh.boxboxassignment.theme.ListElementPadding

@Composable
fun HomeImageCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(HomeCardCornerRadiusRegular))
            .clickable(onClick = {
                onClick()
            }),
    ) {
        Image(
            painter = painterResource(R.drawable.img_insta_card),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Icon(
            painter = painterResource(R.drawable.ic_insta),
            contentDescription = null,
            modifier = Modifier
                .padding(ListElementPadding)
                .size(20.dp)
                .align(Alignment.BottomEnd),
        )
    }
}