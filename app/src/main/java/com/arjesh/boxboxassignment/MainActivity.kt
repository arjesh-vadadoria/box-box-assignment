package com.arjesh.boxboxassignment

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arjesh.boxboxassignment.theme.BoxBoxAssignmentTheme
import com.arjesh.boxboxassignment.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(SystemBarStyle.dark(Color.TRANSPARENT))
        setContent {
            BoxBoxAssignmentTheme {
                AppNavigation()
            }
        }
    }
}