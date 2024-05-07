package com.seenu.dev.charts.data

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed interface ChartType {

    data class Line(
        val lineWidth: Dp = 2.dp
    ) : ChartType

}