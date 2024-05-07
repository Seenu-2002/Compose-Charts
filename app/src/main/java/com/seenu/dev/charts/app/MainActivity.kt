package com.seenu.dev.charts.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.seenu.dev.charts.app.ui.theme.ComposeChartsTheme
import com.seenu.dev.charts.axes.XAxis
import com.seenu.dev.charts.axes.YAxis
import com.seenu.dev.charts.chart.Chart
import com.seenu.dev.charts.data.CartesianPlane
import com.seenu.dev.charts.data.ChartData
import com.seenu.dev.charts.data.ChartType
import com.seenu.dev.charts.data.Point
import com.seenu.dev.charts.data.Series

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeChartsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val xAxis = XAxis("XAxis")
                    val yAxis = YAxis("YAxis")
                    val plane = CartesianPlane(xAxis, yAxis)
                    Chart(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        plane = plane,
                        data = getChartData()
                    )
                }
            }
        }
    }

    private fun getChartData(): ChartData {
        val points = arrayListOf<Point>()
        repeat(10) {
            points.add(Point(it.toDouble(), (0..10).random().toDouble()))
        }
        val series = Series("", Color.Red, points, ChartType.Line())
        return ChartData(series)
    }
}