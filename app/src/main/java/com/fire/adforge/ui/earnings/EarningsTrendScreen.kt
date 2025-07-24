package com.fire.adforge.ui.earnings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.EarningsTrendViewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun EarningsTrendScreen() {
    val vm: EarningsTrendViewModel = viewModel()
    val data by vm.dailyEarnings.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Coin Earnings Trend", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))

        AndroidView(factory = { context ->
            LineChart(context).apply {
                val entries = data.mapIndexed { idx, e ->
                    Entry(idx.toFloat(), e.amount.toFloat())
                }

                val dataSet = LineDataSet(entries, "Coins Earned").apply {
                    lineWidth = 2f
                    circleRadius = 4f
                    setDrawValues(false)
                }

                val lineData = LineData(dataSet)
                this.data = lineData

                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.granularity = 1f
                xAxis.valueFormatter = IndexAxisValueFormatter(data.map { it.date })
                axisRight.isEnabled = false
                description.isEnabled = false
                invalidate()
            }
        }, modifier = Modifier.fillMaxWidth().height(300.dp))
    }
}
