import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
package com.fire.adforge.ui

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fire.adforge.viewmodel.ReceiptQRViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

@Composable
fun ReceiptQRScreen(vm: ReceiptQRViewModel = viewModel()) {
    var qrData by remember { mutableStateOf<String?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("🔲 Receipt QR Code", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = {
            vm.generateQRPayload {
                qrData = it
                bitmap = it?.let { content ->
                    val writer = QRCodeWriter()
                    val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 400, 400)
                    val bmp = Bitmap.createBitmap(400, 400, Bitmap.Config.RGB_565)
                    for (x in 0 until 400) {
                        for (y in 0 until 400) {
                            bmp.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
                        }
                    }
                    bmp
                }
            }
        }) {
            Text("Generate QR")
        }

        Spacer(modifier = Modifier.height(16.dp))

        bitmap?.let {
            Image(bitmap = it.asImageBitmap(), contentDescription = "QR Code")
        }

        qrData?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Raw: ", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

