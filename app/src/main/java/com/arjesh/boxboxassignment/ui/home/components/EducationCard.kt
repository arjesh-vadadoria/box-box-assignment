package com.arjesh.boxboxassignment.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjesh.boxboxassignment.R
import com.arjesh.boxboxassignment.theme.EducationCardBG
import com.arjesh.boxboxassignment.theme.HomeCardCornerRadiusSmall
import com.arjesh.boxboxassignment.theme.ListElementPadding


@Composable
fun EducationCard(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    HomeCard(
        modifier = modifier,
        background = EducationCardBG,
        cornerRadius = HomeCardCornerRadiusSmall,
        onClick = { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_medium),
                contentDescription = null
            )
            Spacer(Modifier.width(ListElementPadding))
            Column {
                Text(
                    text = stringResource(R.string.formula_1),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.sp,
                )
                Text(
                    text = stringResource(R.string.education),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 18.sp,
                )
            }
        }
        Icon(
            painter = painterResource(R.drawable.ic_open_link),
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.TopEnd),
            contentDescription = null,
        )
    }
}

