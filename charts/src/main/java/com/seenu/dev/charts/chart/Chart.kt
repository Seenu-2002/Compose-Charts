package com.seenu.dev.charts.chart

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.seenu.dev.charts.data.CartesianPlane
import com.seenu.dev.charts.data.ChartData
import com.seenu.dev.charts.data.Point

@Composable
fun Chart(modifier: Modifier = Modifier, plane: CartesianPlane, data: ChartData) {
    val (xMax, yMax) = remember {
        computeAxis(plane, data)
    }
    val noOfPoints = data.series.points.size
    val color = data.series.color
    Canvas(modifier = modifier) {
        val width = this.size.width
        val height = this.size.height
        val spaceBetweenPoints = width / (noOfPoints - 1)
        data.series.points.forEachIndexed { index, point ->
            val xPos = (index * spaceBetweenPoints)
            val yPos = getY(point, yMax, height)
            println("Drawing at ${Offset(xPos, yPos)}")
            drawPoints(listOf(Offset(xPos, yPos)), PointMode.Points, color, strokeWidth = 12.dp.toPx(), cap = StrokeCap.Round)
        }
    }
}

private fun getY(point: Point, yMax: Double, height: Float): Float {
    return (height - ((point.y / yMax) * height)).toFloat()
}

private fun computeAxis(plane: CartesianPlane, data: ChartData): Pair<Double, Double> {
    val xAxisMax = data.series.points.maxOf { it.x }
    val yAxisMax = data.series.points.maxOf { it.y }
    return xAxisMax to yAxisMax
}