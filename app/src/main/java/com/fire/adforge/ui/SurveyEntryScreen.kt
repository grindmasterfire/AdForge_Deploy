package com.fire.adforge.ui

import android.content.Intent`nimport com.fire.adforge.backend.SurveyLogWriter
import android.net.Uri`nimport com.fire.adforge.backend.SurveyLogWriter
import androidx.compose.foundation.layout.*`nimport com.fire.adforge.backend.SurveyLogWriter
import androidx.compose.material3.*`nimport com.fire.adforge.backend.SurveyLogWriter
import androidx.compose.runtime.Composable`nimport com.fire.adforge.backend.SurveyLogWriter
import androidx.compose.ui.Modifier`nimport com.fire.adforge.backend.SurveyLogWriter
import androidx.compose.ui.platform.LocalContext`nimport com.fire.adforge.backend.SurveyLogWriter
import androidx.compose.ui.unit.dp`nimport com.fire.adforge.backend.SurveyLogWriter

@Composable
fun SurveyEntryScreen() {
    val ctx = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("📊 Paid Surveys", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Tap a provider to begin earning", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            SurveyLogWriter.logSurveyVisit("Pollfish")`n            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pollfish.com"))
            ctx.startActivity(intent)
        }) {
            Text("🎯 Pollfish")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = {
            SurveyLogWriter.logSurveyVisit("SurveySavvy")`n            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.surveysavvy.com"))
            ctx.startActivity(intent)
        }) {
            Text("🧠 SurveySavvy")
        }
    }
}
