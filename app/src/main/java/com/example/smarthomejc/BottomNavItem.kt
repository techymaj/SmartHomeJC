package com.example.smarthomejc

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
        var name: String,
        var route: String,
        var icon: ImageVector? = null,
        var painter: Painter? = null
    )