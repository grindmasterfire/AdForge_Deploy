package com.fire.adforge.ui.breadloop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.BreadloopViewModel

@Composable
fun LivenessTimeSelector(onStart: () -> Unit) {
    val vm: BreadloopViewModel = viewModel()
    var sliderValue by remember { mutableStateOf(2f) }

    val min = 2f
    val max = 7f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose when you'd like the sponsor moment to appear",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = min..max,
            steps = 10
        )

        Spacer(modifier = Modifier.height(12.dp))
        val mins = sliderValue.toInt()
        val secs = ((sliderValue - mins) * 60).toInt()
        val formatted = String.format("%d:%02d", mins, secs)

        Text("Selected Time:  min", color = Color.Cyan)

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                val millis = (sliderValue * 60 * 1000).toLong()
                vm.selectedLivenessTime.value = millis
                onStart()
            }
        ) {
            Text("Start Autoplay Session")
        }
    }
}
