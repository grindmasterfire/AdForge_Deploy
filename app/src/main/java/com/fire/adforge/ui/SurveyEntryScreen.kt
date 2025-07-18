package com.fire.adforge.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SurveyEntryScreen() {
    val ctx = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("📊 Paid Surveys", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Tap a provider to begin earning", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pollfish.com"))
            ctx.startActivity(intent)
        }) {
            Text("🎯 Pollfish")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.surveysavvy.com"))
            ctx.startActivity(intent)
        }) {
            Text("🧠 SurveySavvy")
        }
    }
}
