package com.seenu.dev.charts.data

import androidx.compose.ui.graphics.Color

data class Series(
    val label: String,
    val color: Color,
    val points: List<Point>,
    val type: ChartType
)