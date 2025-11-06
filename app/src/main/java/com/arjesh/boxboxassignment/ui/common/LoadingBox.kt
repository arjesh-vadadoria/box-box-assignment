package com.arjesh.boxboxassignment.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arjesh.boxboxassignment.theme.DarkBG

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BoxWithLoader(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(modifier) {
        content()
    }
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBG)
        ) {
            LoadingIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
            )
        }
    }
}