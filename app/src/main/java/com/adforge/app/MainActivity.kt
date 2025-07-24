package com.adforge.app

import android.content.Intent
import android.os.Bundle
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adforge.app.databinding.ActivityMainBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.util.UUID
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val editor = prefs.edit()

        var referralCode = prefs.getString("referral_code", null)
        if (referralCode == null) {
            referralCode = generateReferralCode()
            editor.putString("referral_code", referralCode)
        }

        var joinDate = prefs.getString("join_date", null)
        if (joinDate == null) {
            joinDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date())
            editor.putString("join_date", joinDate)
        }

        var sessionCount = prefs.getInt("session_count", 0) + 1
        editor.putInt("session_count", sessionCount)
        editor.apply()

        val crewSize = prefs.getInt("crew_size", 0)

        binding.referralCodeText.text = "Referral Code: \"
        binding.crewSizeText.text = "Crew Size: \"
        binding.joinDateText.text = "Joined: \"
        binding.sessionCountText.text = "Sessions: \"

        binding.referralCodeText.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Referral Code", referralCode)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Referral code copied!", Toast.LENGTH_SHORT).show()
        }

        binding.shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Join me on AdForge! Use my referral code: \")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        binding.resetButton.setOnClickListener {
            prefs.edit().clear().apply()
            val intent = intent
            finish()
            startActivity(intent)
        }

        generateQRCode(referralCode)
    }

    private fun generateReferralCode(): String {
        return UUID.randomUUID().toString().substring(0, 8).uppercase()
    }

    private fun generateQRCode(data: String) {
        val writer = QRCodeWriter()
        try {
            val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
                }
            }

            binding.qrImageView.setImageBitmap(bitmap)

        } catch (e: Exception) {
            Toast.makeText(this, "QR generation failed: \", Toast.LENGTH_SHORT).show()
        }
    }
}
